//package com.zccpro.back.service.impl;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.util.HashMap;
//
//import org.apache.log4j.Logger;
//import org.springframework.stereotype.Service;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.zccpro.back.service.UploadService;
//import com.zccpro.utils.FastDFSUtils;
//import com.zccpro.utils.UploadUtils;
//@Service("uploadService")
//public class UploadServiceImpl<V> implements UploadService {
//	Logger logger = Logger.getLogger(UploadServiceImpl.class);
//
//	public String uploadPicToLocal(MultipartFile pic) {
//		
//		String filename = pic.getOriginalFilename();
//		String path = "G:\\eclipse\\zccProSingle\\zccpro\\src\\main\\webapp\\res\\img\\pic";
//		InputStream in = null;
//		try {
//			in = pic.getInputStream();
//		} catch (IOException e) {
//			logger.error("获取流异常"+e.toString());
//		}
//		UploadUtils uploadUtils = new UploadUtils();
//		boolean flag = uploadUtils.upload(in, filename, path);
//		if(flag){
//			logger.info("图片上传成功。。");
//		}else{
//			logger.info("图片上传失败。。。");
//		}
//		
//		//TODO
//		return "";
//	}
//
//	public String uploadPicToFastDFS(byte[] pic, String name, Long size) throws Exception {
//		String path = FastDFSUtils.uploadPic(pic, name, size);
//		logger.info("异步上传图片成功。"+path);
//		return path;
//	}
//
//}
