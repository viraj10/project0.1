package com.devmanuals.action;

import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.model.Admin;
import com.devmanuals.model.Place;
import com.devmanuals.model.User;
import com.devmanuals.listener.HibernateListener;
import com.devmanuals.model.HighProrityPlaces;
import com.opensymphony.xwork2.ActionSupport;

public class HighPriorityPlacesAction extends ActionSupport implements SessionAware{
	
	private long placeid;
	private long status;
	
	static final Logger LOGGER = Logger.getLogger(HighPriorityPlacesAction.class);
	
	@Override
	public String execute(){
		
		return SUCCESS;
	}
	
	Map<String, Object> sessionMap;
	@Override
	 public void setSession(Map session) {
	    this.sessionMap = session;
	  }
	
	public String addHighPriorityPlace(){
		
		Admin admin=(Admin)this.sessionMap.get("admin");
		
		if(admin==null || admin.getId()<1)
		{
			return "login";
		}
		
		HighProrityPlaces hplace=new HighProrityPlaces();
		HighProrityPlaces hplace1;
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		Session session=sessionFactory.openSession();
		Place place= (Place)session.get(Place.class, placeid);
		
		if(place==null)
			return ERROR;

		LOGGER.info("place selected "+place.getName());
		hplace.setStatus(status);
		hplace.setPlace(place);
		session.beginTransaction();
		Long a=(Long)session.save(hplace);
		LOGGER.info("place selected "+a);
		session.getTransaction().commit();
		session.close();
		
		return SUCCESS;
		
	}

	public long getPlaceid() {
		return placeid;
	}

	public void setPlaceid(long placeid) {
		this.placeid = placeid;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

}
