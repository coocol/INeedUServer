package com.eethan.ineedu.util;

import javax.mail.*;

import java.util.*;
import javax.mail.internet.*;

public class Mail { 
	 String host = "smtp.qq.com";
	 String username = "1641714141";
	 String password = "ee2014@eethan";
	 String sendpeople = "1641714141@qq.com";

	 
	 public void setHost(String host) {
	  this.host = host;
	 }
	 
	 public void setUserInformaition(String username,String password) {
	  this.username = username;
	  this.password = password;
	 }
	 
	 public void sendEmail(String arrviedpeople,String emailname,String content) {
	  Properties props = new Properties();
	  props.put("mail.smtp.host", host);
	  props.put("mail.smtp.auth", true);
	  
	  try {
		   Session mailSession = Session.getDefaultInstance(props);
		   mailSession.setDebug(true);
		   Message msg = new MimeMessage(mailSession);
		   msg.setFrom(new InternetAddress(sendpeople));
		   msg.addRecipient(Message.RecipientType.TO,new InternetAddress(arrviedpeople));//收件人
		   msg.setSubject(emailname);//邮件主题
		   msg.setText(content);//邮件内容
		   msg.saveChanges();
	
		   Transport transport = mailSession.getTransport("smtp");
		   transport.connect(host, username, password);
		   transport.sendMessage(msg, msg.getAllRecipients());
		   transport.close();
		  } catch (AddressException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (NoSuchProviderException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  } catch (MessagingException e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
	  
	 }
	 
}