package com.devmanuals.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.listener.HibernateListener;
import com.opensymphony.xwork2.ActionSupport;

public class AdminLogin extends ActionSupport implements SessionAware{
	
	private static final long serialVersionUID = 982314581234L;
	
	Map<String, Object> sessionMap;
	 
	@Override
	 public void setSession(Map session) {
	    this.sessionMap = session;
	  }
	
	String adminUserName, adminPassword;
	
	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminUserName() {
		return adminUserName;
	}

	public void setAdminUserName(String adminUserName) {
		this.adminUserName = adminUserName;
	}
	
	@Override
	public String execute(){
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		Session session=sessionFactory.openSession();
		Query checkUser=session.createQuery("from Admin u where u.username=:USERNAME and u.password=:PASSWORD");
		
		checkUser.setParameter("USERNAME", adminUserName);
		checkUser.setParameter("PASSWORD", adminPassword);
		
		List admin=checkUser.list();
		
		if(admin.size()>0){
			System.out.print("success admin***********");
			sessionMap.put("admin",admin.get(0));
			session.close();
			return SUCCESS;
		}else{
			System.out.print("error admin!!!!!!!!!!!!!!!");
			session.close();
			return ERROR;
		}
		
	}

	

}
