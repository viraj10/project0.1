package com.devmanuals.action;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.model.Admin;
import com.devmanuals.model.Place;
import com.devmanuals.model.User;
import com.devmanuals.listener.HibernateListener;
import com.devmanuals.model.HighProrityPlaces;
import com.opensymphony.xwork2.ActionSupport;

public class HighPriorityPlacesAction extends ActionSupport implements SessionAware{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7362065072670413347L;
	
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
		
		
		
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		Session session=sessionFactory.openSession();
		Place place= (Place)session.get(Place.class, placeid);
		Query query=session.createQuery("from HighProrityPlaces h where placeid=:placeid ");
		query.setParameter("placeid", placeid);
		List hplaceList=query.list();
		HighProrityPlaces hplace;
		if(place==null)
			return ERROR;
		session.beginTransaction();
		if(hplaceList.size()==0)
		{	
			hplace=new HighProrityPlaces();
			LOGGER.info("new HighProrityPlaces and place selected "+place.getName());
			hplace.setStatus(status);
			hplace.setPlace(place);
			
			Long a=(Long)session.save(hplace);
			LOGGER.info("place selected "+a);
		}else{
			hplace=(HighProrityPlaces)hplaceList.get(0);
			hplace.setStatus(status);
			session.update(hplace);
		}
		session.getTransaction().commit();
		session.close();
		
		return SUCCESS;
		
	}
	
	public String removeHighPriorityPlace(){
		
		Admin admin=(Admin)this.sessionMap.get("admin");
		
		if(admin==null || admin.getId()<1)
		{
			return "login";
		}
				
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from HighProrityPlaces h where placeid=:placeid ");
		query.setParameter("placeid", placeid);
		List hplaceList=query.list();
		if(hplaceList.size()==0 || hplaceList.size()>1)
			return ERROR;
		
		HighProrityPlaces hplace= (HighProrityPlaces)hplaceList.get(0);
		LOGGER.info("place selected  to remove "+hplace.getPlace().getName());
		
		session.beginTransaction();
		session.delete(hplace);
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
