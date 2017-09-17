//package com.zccpro.back.controller;
//
//import java.util.Map;
//import java.util.Map.Entry;
//import java.util.Set;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.multipart.MultipartHttpServletRequest;
//
//import com.alibaba.fastjson.JSONObject;
//import com.zccpro.back.service.UploadService;
//import com.zccpro.constants.Constants;
//
//import net.fckeditor.response.UploadResponse;
//
//
//@Controller
//public class UploadController {
//
//	@Autowired
//	private UploadService uploadService;
//	//上传
//	@RequestMapping(value = "/upload/uploadPic.do")
//	public void uploadPic(@RequestParam(required = false) MultipartFile pic,HttpServletResponse response) throws Exception{
//		String path = uploadService.uploadPicToFastDFS(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
//		String url = Constants.IMG_URL+path;
//		System.out.println(url);
//		JSONObject jo = new JSONObject();
//		jo.put("url", url);
//		jo.put("path", path);
//		response.setContentType("application/json;charset=UTF-8");
//		response.getWriter().write(jo.toString());
//	}
//	//上传Fck
//		@RequestMapping(value = "/upload/uploadFck.do")
//		public void uploadFck(HttpServletRequest request, HttpServletResponse response) throws Exception{
//			
//			//接收图片  强转成 只有图片的request
//			MultipartHttpServletRequest mr = (MultipartHttpServletRequest)request;
//			//从MultipartHttpServletRequest取出图片
//			Map<String, MultipartFile> fileMap = mr.getFileMap();
//			//遍历Map
//			Set<Entry<String, MultipartFile>> entrySet = fileMap.entrySet();
//			for (Entry<String, MultipartFile> entry : entrySet) {
//				//图片
//				MultipartFile pic = entry.getValue();
//				
//				//上传图片到FastDFS分布式文件系统中去
//				String path = uploadService.uploadPicToFastDFS(pic.getBytes(), pic.getOriginalFilename(), pic.getSize());
//				
//				// url 
//				String url = Constants.IMG_URL + path;
//				//返回Fck的图片路径
//				//  java-core-2.6.jar
//				UploadResponse ok = UploadResponse.getOK(url);
//				
//				response.getWriter().print(ok);
//			}
//			
//			
//			
//			
//		}
//}
