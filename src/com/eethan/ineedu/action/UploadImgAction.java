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

public class UploadImgAction  extends ActionSupport implements ServletRequestAware ,ServletResponseAware{


	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	// 上传文件域
	private File image;
	// 上传文件类型
	private String imageContentType;
	// 封装上传文件名
	private String imageFileName;
	

	

	
	public void uploadImg() {
	    HttpServletRequest request=ServletActionContext.getRequest();
	    FileOutputStream fos = null;
	    FileInputStream fis = null;
	    try {
	        System.out.println("获取Android端传过来的文件信息：");
	        System.out.println("文件存放目录: "+ ServletActionContext.getServletContext().getRealPath("/")+ "head/");
	        System.out.println("文件名称: "+imageFileName);
	        System.out.println("文件大小: "+image.length());
	        System.out.println("文件类型: "+imageContentType);
	        
	        
	        
	        fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/")+ "head/"+imageFileName);
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
	public void uploadShareImg() {
	    HttpServletRequest request=ServletActionContext.getRequest();
	    FileOutputStream fos = null;
	    FileInputStream fis = null;
	    try {
	        //绝对地址，自己改
	        fos = new FileOutputStream("/mnt/webfeedserver/share/"+imageFileName);
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
	public void uploadCustomBackground() {
	    HttpServletRequest request=ServletActionContext.getRequest();
	    FileOutputStream fos = null;
	    FileInputStream fis = null;
	    try {
	        fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/")+ "customBackground/"+imageFileName);
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
	public void uploadTakePhotos() {
	    HttpServletRequest request=ServletActionContext.getRequest();
	    FileOutputStream fos = null;
	    FileInputStream fis = null;
	    try {
	        fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/")+ "TakePhotos/"+imageFileName);
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
	public void uploadAlbumPhoto() {
	    HttpServletRequest request=ServletActionContext.getRequest();
	    FileOutputStream fos = null;
	    FileInputStream fis = null;
	    try {
	        fos = new FileOutputStream(ServletActionContext.getServletContext().getRealPath("/")+ "album/"+imageFileName);
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
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
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
