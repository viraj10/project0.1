package com.getbestplace.action.search;


import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import com.getbestplace.listener.HibernateListener;
import com.getbestplace.model.Place;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class SelectedPlaceRender extends ActionSupport{

	private static final long serialVersionUID = -15005875022901221L;
	private String placeName;
	static final Logger LOGGER = Logger.getLogger(SelectedPlaceRender.class);
	private Place place;
	
	@Override
	public String execute(){
		LOGGER.info("insode SelectedPlaceRender with name as"+placeName);
		SessionFactory sessionFactory=(SessionFactory)ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("FROM Place p WHERE p.name= :pname");
		query.setParameter("pname", placeName);
		
		this.setPlace((Place)query.list().get(0));
		Hibernate.initialize(getPlace().getAttributes());
		session.close();
		return Action.SUCCESS;
	}
	public String getPlaceName() {
		return placeName;
	}
	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}
	
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
}
