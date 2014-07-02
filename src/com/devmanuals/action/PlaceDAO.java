package com.devmanuals.action;


import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.model.Attribute;
import com.devmanuals.model.Place;
import com.devmanuals.model.User;
import com.devmanuals.listener.HibernateListener;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class PlaceDAO  extends ActionSupport  implements ModelDriven<Place> , SessionAware{

	/**
	 * 
	 */
	
	
	
	static final Logger LOGGER = Logger.getLogger(PlaceDAO.class);
	
	Map<String, Object> sessionMap;
	@Override
	 public void setSession(Map session) {
	    this.sessionMap = session;
	  }
	
	
	
	private static final long serialVersionUID = 6427837709720937902L;
	Place placeBean= new Place();

	public Place getPlaceBean() {
		return placeBean;
	}

	public void setPlaceBean(Place placeBean) {
		this.placeBean = placeBean;
	}

	public Place getModel() {
		return placeBean;
	}
	
	
	public String addPlace() throws Exception{
		
		User userObj;
		userObj=(User)this.sessionMap.get("currentUser");
		
		if(userObj==null || userObj.getUserId()<1)
		{
			return "login";
		}
		LOGGER.info("This is a userObj id"+userObj.getUserId());
		
		
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		Session session=sessionFactory.openSession();
		
		Attribute attribute=new Attribute();
		
		attribute.setAttributeName("AC");
		attribute.setStringValue("Yes");
		
		attribute.setPlace(placeBean);
		session.beginTransaction();
		session.save(placeBean);
		session.save(attribute);
		
		session.getTransaction().commit();
		
		return SUCCESS;
	}
	
}

