package com.devmanuals.action;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.model.Admin;
import com.devmanuals.model.Place;
import com.devmanuals.model.User;
import com.devmanuals.listener.HibernateListener;
import com.devmanuals.model.HighProrityPlaces;
import com.devmanuals.util.JsonUtils;
import com.opensymphony.xwork2.ActionSupport;

public class HighPriorityPlacesAction extends ActionSupport implements SessionAware,ServletResponseAware{
	
	/**
	 * 
	 */
	private HttpServletResponse response;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
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
		/*check if exists in the system*/
		Query query=session.createQuery("from HighProrityPlaces h where place.id=:placeid ");
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
		Query query=session.createQuery("from HighProrityPlaces h where place.id=:placeid");
		query.setParameter("placeid",placeid);
		List hplaceList=query.list();
		if(hplaceList.size()==0 || hplaceList.size()>1)
			return ERROR;
		
		HighProrityPlaces hplace= (HighProrityPlaces)hplaceList.get(0);
		
		LOGGER.info("place selected  to remove "+hplace.getPlace().getName());
		
		session.beginTransaction();
		session.delete(hplace);
		LOGGER.info("place selected ");
		session.getTransaction().commit();
		session.close();
		
		return SUCCESS;
		
	}
	
	public String getHighPriorityPlace() throws Exception{
		
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		
		Session session=sessionFactory.openSession();
		
		Query query=session.createQuery("from HighProrityPlaces h where status=:status");
		query.setParameter("status", 10L);
		List<HighProrityPlaces> hplaceList=query.list();
			
		
		query.setParameter("status", 5L);
		List<HighProrityPlaces> mplaceList=query.list();
		
		String jsonResponse=JsonUtils.getJsonFromList(hplaceList,mplaceList);
		session.close();
		
		response.getWriter().write(jsonResponse);
		response.getWriter().flush();
		
		
		return NONE;
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
