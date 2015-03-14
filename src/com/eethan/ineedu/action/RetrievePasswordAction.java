package com.eethan.ineedu.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import com.eethan.ineedu.databasebeans.User;
import com.eethan.ineedu.databasedao.UserDAO;
import com.eethan.ineedu.jackson.JacksonUtil;
import com.eethan.ineedu.jackson.JsonObject;
import com.eethan.ineedu.util.Mail;
import com.opensymphony.xwork2.ActionSupport;

public class RetrievePasswordAction extends ActionSupport implements ServletRequestAware ,ServletResponseAware{


	protected HttpServletRequest request;
	protected HttpServletResponse response;
	
	private String data;
	public boolean isEncrypt;//接受的数据是否被加密(兼容新老版本)
	
    @Override
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public void retrievePassword() {
		String dString = data;
		String dataString = request.getParameter("data");
		JsonObject jsonObject = JacksonUtil.json().fromJsonToObject(dataString, JsonObject.class);

		String email=jsonObject.getString1()+"@"+jsonObject.getString2()+".com";
		System.out.println(email);
		UserDAO userDAO = new UserDAO();
		List<User> users = userDAO.findByProperty(UserDAO.EMAIL, email);
		if(users.size()>0){
			User user = users.get(0);
		    Mail mail = new Mail();
		    mail.sendEmail(user.getEmail(), "您的密码已找回", "密码为"+user.getPassword());
			outToClient(true);
		}else {
			outToClient(false);
		}
	}
	
	private void outToClient(Object data) {
		// TODO Auto-generated method stub

		PrintWriter out = null;
		try {
			this.response.setContentType("text/html;charset=UTF-8");
			out = this.response.getWriter();
			String  jacksonString = JacksonUtil.json().fromObjectToJson(data);
			out.write(jacksonString);
			System.out.println(jacksonString);
		} catch (Exception e) {
			e.printStackTrace();
			
		}finally{
			try{
				if(out!=null){
					out.flush();
					out.close();
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}