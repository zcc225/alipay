package com.zccpro.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;

public class UploadUtils {
	Logger logger = Logger.getLogger(UploadUtils.class);
	//文件写入指定目录
	public boolean upload(InputStream in,String filename,String path){
		String imgUrl = path+File.separator+filename;
		FileOutputStream fio = null;
		try {
			fio = new FileOutputStream(imgUrl);
			byte buffer[] = new byte[1024];
			int len = 0;
			while((len = in.read(buffer))>0){
				fio.write(buffer,0,len);
			}
			return true;
		} catch (FileNotFoundException e) {
			logger.error("文件不存在。。。"+e.toString());
			return false;
		} catch (IOException e) {
			logger.error("读取异常。。。"+e.toString());
			return false;
		}finally {
			try {
				if(fio!=null){
				fio.close();
				}
				if(in!=null){
					in.close();
				}
			} catch (IOException e) {
				logger.info("输出输出流关闭异常"+e.toString());
			} 
		}
	}
}
