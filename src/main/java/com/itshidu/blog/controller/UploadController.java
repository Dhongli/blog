package com.itshidu.blog.controller;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;
import java.util.UUID;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.itshidu.blog.util.FileDownload;
import com.itshidu.blog.vo.Result;

import net.coobird.thumbnailator.Thumbnails;


@Controller
public class UploadController {
	
	@Value("${STORE_ROOT_PATH}")
	String StoreRootPath; //存储根目录

	@ResponseBody
	@RequestMapping("/post/upload")
	public Object upload(int size,MultipartFile file,HttpServletRequest request) {
		System.out.println("文件大小："+file.getSize());
		System.out.println("缩放尺寸："+size);
		System.out.println(StoreRootPath);
		try {
			
			BufferedImage bi = ImageIO.read(file.getInputStream());
			int w=bi.getWidth();
			int h=bi.getHeight();
			int max = (int) Math.max(w, h);
	        int tow = w;
	        int toh = h;
	        if (max > size) {
	            if (w > h) {
	                tow = size;
	                toh = h * size / w;
	            } else {
	                tow = w * size / h;
	                toh = size;
	            }
	        }
	        
	        String filename = "/store/temp/"+UUID.randomUUID().toString()+".jpg";
	        File tempFile = new File(StoreRootPath,filename); //临时文件
	        File parent = tempFile.getParentFile();
	        if(!parent.exists()) {
	        	parent.mkdirs();
	        }
	        Thumbnails.of(file.getInputStream())
		        		.size(tow, toh)
		        		.outputFormat("jpg")
		        		.toFile(tempFile);
	        return Result.of(1, "上传成功",filename);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Result.of(2, "上传失败");
	}
	@ResponseBody
	@RequestMapping("/store/temp/{filename:.+}")
	public Object upload(@PathVariable String filename,HttpServletRequest request,HttpServletResponse response) {
		File file = new File(StoreRootPath,"/store/temp/"+filename);
		try {
			FileDownload.forward(request, response, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	@ResponseBody
	@RequestMapping("/store/avatar/**")
	public Object avatar(HttpServletRequest request,HttpServletResponse response) {
		System.out.println(request.getServletPath());
		File file = new File(StoreRootPath,request.getServletPath());
		try {
			FileDownload.forward(request, response, file,"a.zip",false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
}
