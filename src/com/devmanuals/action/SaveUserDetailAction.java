package com.devmanuals.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.model.User;
import com.devmanuals.listener.HibernateListener;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SaveUserDetailAction  extends ActionSupport {

	
	
	Long userId;
	String regName;
	String regInputPassword;
	String regInputEmail;
	String regInputAddress;
	String regInputCity;
	Long regUserPhone;
	Long regInputPostcode;
	

	

	
		
	public String execute() throws Exception{
		System.out.print("SaveUserDetailAction");
		return SUCCESS;
	}
	
	public String addUser() throws Exception{
		
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
	
	
	
}
