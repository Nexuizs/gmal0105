package com.lzk.gmall.manage;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
public class GmallManageWebApplicationTests {

    @Test
    public void contextLoads() throws IOException, MyException {
        //配置fdfs全局链接地址
        String tracker = GmallManageWebApplication.class.getResource("/tracker.conf").getPath(); //获取配置文件路径
        ClientGlobal.init(tracker);
        TrackerClient trackerClient = new TrackerClient();
        //获取一个的trackerServer实例
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        //通过tracker获得一个Storage的连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);
        String[] uploadInfo = storageClient.upload_file("C:/Users/Nexuiz/Pictures/Camera Roll/2e8wgy.jpg",
                "jpg", null);
        for (String s : uploadInfo) {
            System.out.println(s);
        }

    }

}
