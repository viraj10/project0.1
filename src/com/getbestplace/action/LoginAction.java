package com.devmanuals.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.devmanuals.model.User;

import com.devmanuals.listener.HibernateListener;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware{

	
	private static final long serialVersionUID = 98231458L;
	
	Map<String, Object> sessionMap;
	 
	@Override
	 public void setSession(Map session) {
	    this.sessionMap = session;
	  }
	
	String userEmail;
	String userPassword;
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	
	@Override
	public String execute(){
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		Session session=sessionFactory.openSession();
		Query checkUser=session.createQuery("from User u where u.email=:emailid and u.password=:password");
		
		checkUser.setParameter("emailid", userEmail);
		checkUser.setParameter("password", userPassword);
		
		List userList=checkUser.list();
		
		if(userList.size()>0){
			System.out.print("success***********");
			sessionMap.put("currentUser",userList.get(0));
			session.close();
			return SUCCESS;
		}else{
			System.out.print("error!!!!!!!!!!!!!!!");
			session.close();
			return ERROR;
		}
		
	}
	
}
