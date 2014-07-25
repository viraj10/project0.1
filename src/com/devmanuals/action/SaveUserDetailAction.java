package com.devmanuals.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.model.User;
import com.devmanuals.listener.HibernateListener;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveUserDetailAction  extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 6565789123L;
	
	static final Logger LOGGER = Logger.getLogger(SaveUserDetailAction.class);
	
	Map<String, Object> sessionMap;
	@Override
	 public void setSession(Map session) {
	    this.sessionMap = session;
	  }
	  
	  
	
	Long userId;
	String regName;
	String regInputPassword;
	String regInputEmail;
	String regInputAddress;
	String regInputCity;
	Long regUserPhone;
	Long regInputPostcode;
	private String regInputCaptcha;

	

	
		
	public String execute() throws Exception{
		System.out.print("SaveUserDetailAction");
		return SUCCESS;
	}
	
	public String addUser() throws Exception{
		
		LOGGER.info("This is a debug log message from Struts2");
        
		String captcha=(String)this.sessionMap.get("captchaValue");
		LOGGER.info(getRegInputCaptcha()+"==="+captcha+" "+regInputCaptcha.equalsIgnoreCase(captcha));
		if(captcha==null || !regInputCaptcha.equalsIgnoreCase(captcha))
		{
			sessionMap.remove("captchaValue");
			return "login";
		}
		sessionMap.remove("captchaValue");
		
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		Session session=sessionFactory.openSession();
		
		/*inserting dummy values for testing purpose
		 * user.setAddress("sample address");
		user.setCity("pune city");
		user.setCreationDate(new Date());
		user.setEmail("abc@cam.com");
		user.setPassword("password");
		user.setPhone(89898989L);
		user.setPostalCode(411006L);
		user.setUserName("user name");*/
		User userbean = new User();
		userbean.setPhone(regUserPhone);
		userbean.setPostalCode(regInputPostcode);
		userbean.setPassword(regInputPassword);
		userbean.setEmail(regInputEmail);
		userbean.setCity(regInputCity);
		userbean.setUserName(regName);
		userbean.setAddress(regInputAddress);
		userbean.setCreationDate(new Date());
		session.beginTransaction();
		session.save(userbean);
		sessionMap.put("currentUser", userbean);
		session.getTransaction().commit();
		
		return SUCCESS;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public String getRegInputPassword() {
		return regInputPassword;
	}

	public void setRegInputPassword(String regInputPassword) {
		this.regInputPassword = regInputPassword;
	}

	public String getRegInputEmail() {
		return regInputEmail;
	}

	public void setRegInputEmail(String regInputEmail) {
		this.regInputEmail = regInputEmail;
	}

	public String getRegInputAddress() {
		return regInputAddress;
	}

	public void setRegInputAddress(String regInputAddress) {
		this.regInputAddress = regInputAddress;
	}

	public String getRegInputCity() {
		return regInputCity;
	}

	public void setRegInputCity(String regInputCity) {
		this.regInputCity = regInputCity;
	}

	public Long getRegUserPhone() {
		return regUserPhone;
	}

	public void setRegUserPhone(Long regUserPhone) {
		this.regUserPhone = regUserPhone;
	}

	public Long getRegInputPostcode() {
		return regInputPostcode;
	}

	public void setRegInputPostcode(Long regInputPostcode) {
		this.regInputPostcode = regInputPostcode;
	}

	public String getRegInputCaptcha() {
		return regInputCaptcha;
	}

	public void setRegInputCaptcha(String regInputCaptcha) {
		this.regInputCaptcha = regInputCaptcha;
	}
	
	
	
}
