package com.lzk.gmall.manage.service.impl;

import javax.annotation.Resource;

import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.lzk.gmall.bean.PmsSkuAttrValue;
import com.lzk.gmall.bean.PmsSkuImage;
import com.lzk.gmall.bean.PmsSkuInfo;
import com.lzk.gmall.bean.PmsSkuSaleAttrValue;
import com.lzk.gmall.manage.mapper.PmsSkuAttrValueMapper;
import com.lzk.gmall.manage.mapper.PmsSkuImageMapper;
import com.lzk.gmall.manage.mapper.PmsSkuInfoMapper;
import com.lzk.gmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import com.lzk.gmall.service.PmsSkuInfoService;
import com.lzk.gmall.util.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.Jedis;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class PmsSkuInfoServiceImpl implements PmsSkuInfoService{

    @Resource
    private PmsSkuInfoMapper pmsSkuInfoMapper;

    @Resource
    private PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Resource
    private PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Resource
    private PmsSkuImageMapper pmsSkuImageMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsSkuInfoMapper.deleteByPrimaryKey(id);
    }

    @Autowired
    RedisUtil redisUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insert(PmsSkuInfo record) {
        record.setProductId(record.getSpuId());
        int i = pmsSkuInfoMapper.insert(record);
        Long skuId = record.getId();
        if(i > 0){
            List<PmsSkuAttrValue> pmsSkuAttrValueList = record.getSkuAttrValueList();
            for (PmsSkuAttrValue pmsSkuAttrValue : pmsSkuAttrValueList) {
                pmsSkuAttrValue.setSkuId(skuId);
                int j = pmsSkuAttrValueMapper.insert(pmsSkuAttrValue);
                if(j == 0){
                    return 0;
                }
            }
            List<PmsSkuSaleAttrValue> skuSaleAttrValueList = record.getSkuSaleAttrValueList();
            for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
                pmsSkuSaleAttrValue.setSkuId(skuId);
                int z = pmsSkuSaleAttrValueMapper.insert(pmsSkuSaleAttrValue);
                if(z == 0){
                    return 0;
                }
            }
            List<PmsSkuImage> skuImageList = record.getSkuImageList();
            for (PmsSkuImage pmsSkuImage : skuImageList) {
                pmsSkuImage.setSkuId(skuId);
                pmsSkuImage.setProductImgId(pmsSkuImage.getSpuImgId());
                int y = pmsSkuImageMapper.insert(pmsSkuImage);
                if(y == 0){
                    return 0;
                }
            }
        }
        return 1;
    }

    @Override
    public int insertSelective(PmsSkuInfo record) {
        return pmsSkuInfoMapper.insertSelective(record);
    }

    @Override
    public PmsSkuInfo selectByPrimaryKey(Long id) {
        return pmsSkuInfoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsSkuInfo record) {
        return pmsSkuInfoMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsSkuInfo record) {
        return pmsSkuInfoMapper.updateByPrimaryKey(record);
    }

    @Override
    public PmsSkuInfo getSkuById(Long skuId) {
        PmsSkuInfo pmsSkuInfo = null;
        Jedis jedis = redisUtil.getJedis();
        String skuKey = "sku:" + skuId + ":info";
        String skuJson = jedis.get(skuKey);
        if(StringUtils.isNoneBlank(skuJson)){
            pmsSkuInfo = JSON.parseObject(skuJson, PmsSkuInfo.class);
        }else{
            //nx redis自带分布式锁，只有为空时才可以set成功
            String token = UUID.randomUUID().toString();
            String OK = jedis.set("sku:" + skuId + ":lock", token, "nx", "px", 10000);
            if(StringUtils.isNotBlank(OK) && OK.equals("OK")){
                pmsSkuInfo = pmsSkuInfoMapper.selectByPrimaryKey(skuId);
                //mysql查询结果存入redis
                if(null != pmsSkuInfo){
                    jedis.set(skuKey, JSON.toJSONString(pmsSkuInfo));
                }else{
                    //数据库中不存在sku
                    //为了防止缓存穿透，将null值或者空字符串值设置给redis
                    jedis.setex(skuKey, 60*3, JSON.toJSONString(""));
                }
                //在访问mysql后，将mysql的分布式锁释放
                String lockToken = jedis.get("sku:" + skuId + ":lock");
                //说明：当刚好锁过期，其他线程获取到锁，本线程删除锁时，删除了其他线程获取的锁，所以需要判断删除的锁是不是自己的锁
                if(StringUtils.isNotBlank(lockToken) && lockToken.equals(token)){
                    //说明：在判断locktoken时刚好锁过期了，其他线程获取到锁，然后本线程把其他线程的锁删除了，所以使用lua脚本，缩短时间
                    //jedis.eval("lua") 可以用lua脚本，在查询到key时同时删除该key，防止高并发下发生特殊情况
                    jedis.del("sku:" + skuId + ":lock");//用token确认锁是自己的
                }
            }else{
                //设置失败，自旋(该线程在睡眠几秒后，重新访问)
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return getSkuById(skuId);
            }
        }
        jedis.close();
        //sku图片集合
        List<PmsSkuImage> pmsSkuImageList =  pmsSkuImageMapper.selectBySkuId(skuId);
        pmsSkuInfo.setSkuImageList(pmsSkuImageList);
        return pmsSkuInfo;
    }

    @Override
    public List<PmsSkuInfo> getSkuSaleAttrValueListBySpu(Long productId) {
        return pmsSkuInfoMapper.getSkuSaleAttrValueListBySpu(productId);
    }

}
