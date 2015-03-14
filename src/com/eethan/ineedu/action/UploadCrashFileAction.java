package com.eethan.ineedu.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.opensymphony.xwork2.ActionSupport;

public class UploadCrashFileAction  extends ActionSupport implements ServletRequestAware ,ServletResponseAware{


	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	// 上传文件域
	private File crashFile;
	// 上传文件类型
	private String ContentType;
	// 封装上传文件名
	private String fileName;
	

	

	
	public void uploadCrashFile() {
	    HttpServletRequest request=ServletActionContext.getRequest();
	    FileOutputStream fos = null;
	    FileInputStream fis = null;
	    try {
	        System.out.println("获取Android端传过来的文件信息：");
	        System.out.println("文件存放目录: "+ ServletActionContext.getServletContext().getRealPath("/")+ "crashFile/");
	        System.out.println("文件名称: "+fileName);
	        System.out.println("文件大小: "+crashFile.length());
	        System.out.println("文件类型: "+ContentType);
	        
	        
	        
	        fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/")+ "crashFile/"+fileName);
	        fis = new FileInputStream(getImage());
	        byte[] buffer = new byte[1024];
	        int len = 0;
	        while ((len = fis.read(buffer)) != -1) {
	            fos.write(buffer, 0, len);
	        }
	        System.out.println("文件上传成功");
	    } catch (Exception e) {
	        System.out.println("文件上传失败");
	        e.printStackTrace();
	    } finally {
	        close(fos, fis);
	    }
	}
	
	
    @Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
    
    public File getImage() {
        return crashFile;
    }

    public void setImage(File image) {
        this.crashFile = image;
    }

    public String getImageContentType() {
        return ContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.ContentType = imageContentType;
    }

    public String getImageFileName() {
        return fileName;
    }

    public void setImageFileName(String imageFileName) {
        this.fileName = imageFileName;
    }

    private void close(FileOutputStream fos, FileInputStream fis) {
        if (fis != null) {
            try {
                fis.close();
                fis=null;
            } catch (IOException e) {
                System.out.println("FileInputStream关闭失败");
                e.printStackTrace();
            }
        }
        if (fos != null) {
            try {
                fos.close();
                fis=null;
            } catch (IOException e) {
                System.out.println("FileOutputStream关闭失败");
                e.printStackTrace();
            }
        }      
    }
}
