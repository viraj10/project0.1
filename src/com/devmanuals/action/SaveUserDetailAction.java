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

public class SaveUserDetailAction  extends ActionSupport 
implements ModelDriven {

	User userbean = new User();
	
	String emailIdToCheck;

	public String getEmailIdToCheck() {
		return emailIdToCheck;
	}

	public void setEmailIdToCheck(String emailIdToCheck) {
		this.emailIdToCheck = emailIdToCheck;
	}

	public User getUserbean() {
		return userbean;
	}

	public void setUserbean(User userbean) {
		this.userbean = userbean;
	}

	public Object getModel() {
		return userbean;
	}
	
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
		userbean.setCreationDate(new Date());
		session.beginTransaction();
		session.save(userbean);
		session.getTransaction().commit();
		
		return SUCCESS;
	}
	
	public String checkExistingEmail() throws Exception{
		userbean.setEmail(emailIdToCheck);
		/*SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		Session session=sessionFactory.openSession();
		
		session.beginTransaction();
		session.get(userbean);*/
		
		
		return SUCCESS;
	}
	
}
