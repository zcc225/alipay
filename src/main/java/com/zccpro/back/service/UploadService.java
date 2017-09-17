package com.zccpro.back.service;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {
	//本地存储
	public String uploadPicToLocal(MultipartFile pic);
	
	public String uploadPicToFastDFS(byte[] pic ,String name,Long size) throws Exception;
}
