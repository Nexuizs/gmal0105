package util;

import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

public class PmsUploadUtil {

    public static String uploadImage(MultipartFile multipartFile) {
        String imgUrl = "http://192.168.136.131";
        //配置fdfs全局链接地址
        String tracker = PmsUploadUtil.class.getResource("/tracker.conf").getPath(); //获取配置文件路径
        try {
            ClientGlobal.init(tracker);
        } catch (Exception e) {
            e.printStackTrace();
        }
        TrackerClient trackerClient = new TrackerClient();
        //获取一个的trackerServer实例
        TrackerServer trackerServer = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //通过tracker获得一个Storage的连接客户端
        StorageClient storageClient = new StorageClient(trackerServer, null);
        try {
            byte[] bytes = multipartFile.getBytes();//获取上传的二级制对象
            //获取文件后缀名
            String originalFilename = multipartFile.getOriginalFilename();//xxx.jpg
            int i = originalFilename.lastIndexOf(".");
            String extName = originalFilename.substring(i + 1);
            String[] uploadInfo = storageClient.upload_file(bytes, extName, null);
            for (String s : uploadInfo) {
                imgUrl += "/" + s;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imgUrl;
    }
}
