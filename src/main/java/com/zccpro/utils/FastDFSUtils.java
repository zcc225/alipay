//package com.zccpro.utils;
//
//import org.apache.commons.io.FilenameUtils;
//import org.csource.common.NameValuePair;
//import org.csource.fastdfs.ClientGlobal;
//import org.csource.fastdfs.StorageClient1;
//import org.csource.fastdfs.StorageServer;
//import org.csource.fastdfs.TrackerClient;
//import org.csource.fastdfs.TrackerServer;
//import org.springframework.core.io.ClassPathResource;
//
///**
// * 连接FastDFS服务器
// * @author lx
// *
// */
//public class FastDFSUtils {
//
//	
//	//上传图片   Java接口连接Fast
//	public static String uploadPic(byte[] pic,String name,Long size) throws  Exception{
//		//获取  "fdfs_client.conf"  所在位置
//		ClassPathResource resource  = new ClassPathResource("fdfs_client.conf");
//		//第一步：全局设置配置信息
//		ClientGlobal.init(resource.getClassLoader().getResource("fdfs_client.conf").getPath());
//		//第二步：创建连接Tracker的客户端
//		TrackerClient trackerClient = new TrackerClient();
//		
//		//返回storage地址
//		TrackerServer trackerServer = trackerClient.getConnection();
//		
//		//创建小弟客户端
//		StorageServer storageServer = null;
//		StorageClient1 storageClient1  = new StorageClient1(trackerServer,storageServer);
//		//获取扩展名
//		String ext = FilenameUtils.getExtension(name);
//		
//		NameValuePair[] meta_list = new NameValuePair[3];
//		meta_list[0] = new NameValuePair("filename",name);
//		meta_list[1] = new NameValuePair("fileext",ext);
//		meta_list[2] = new NameValuePair("filesize",String.valueOf(size));
//		//上传图片
//		//  group1/M00/00/01/wKjIgFWOYc6APpjAAAD-qk29i78248.jpg
//		String path = storageClient1.upload_file1(pic, ext, meta_list);
//		return path;
//	}
//}
