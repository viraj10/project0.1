package com.getbestplace.action;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.getbestplace.model.User;
import com.getbestplace.listener.HibernateListener;
import com.opensymphony.xwork2.Action;

public class CheckUserEmail  implements Action,ServletResponseAware {

	private String emailIdToCheck;
	
	
	private HttpServletResponse response;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
    

	public String execute() throws Exception {
		
		
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		Session session=sessionFactory.openSession();
		Query queryEmail=session.createQuery("select count(u) from User u where u.email=:email ");
		queryEmail.setParameter("email",emailIdToCheck);
		Long intCount=(Long)queryEmail.list().get(0);
		response.getWriter().write(intCount>0?"false":"true");
		response.getWriter().flush();
		session.close();
		
		
    	return Action.NONE;
    }
	
	public String getEmailIdToCheck() {
		return emailIdToCheck;
	}
	
	
	public void setEmailIdToCheck(String emailIdToCheck) {
		this.emailIdToCheck = emailIdToCheck;
	}
    
    

    
	
}
