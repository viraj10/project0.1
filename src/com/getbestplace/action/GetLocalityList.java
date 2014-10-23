package com.getbestplace.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.getbestplace.listener.HibernateListener;
import com.getbestplace.model.Locality;
import com.getbestplace.util.JsonUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GetLocalityList extends ActionSupport{

	/**
	 * 
	 */
	static final Logger LOGGER = Logger.getLogger(GetLocalityList.class);
	
	
	private static final long serialVersionUID = 111001298L;

	private String citySelected;
	
	private Object jsonModel;
	private Locality hideClassNameInJson;
	
	@Override
	public String execute(){
		
		return SUCCESS;
	}
	
	
	
	
	public String getLocalityInCity() throws Exception{
		
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		Session session=sessionFactory.openSession();
		Query queryEmail=session.createQuery("from Locality l where l.city=:city ");
		queryEmail.setParameter("city",getCitySelected());
		List localityList=queryEmail.list();
		setJsonModel(localityList);
		setHideClassNameInJson(new Locality());
		LOGGER.info(localityList.toString());
		session.close();
		return Action.SUCCESS;
	}

	public String getCitySelected() {
		return citySelected;
	}

	public void setCitySelected(String citySelected) {
		this.citySelected = citySelected;
	}

	public Object getJsonModel() {
		return jsonModel;
	}

	public void setJsonModel(Object jsonModel) {
		this.jsonModel = jsonModel;
	}

	public Locality getHideClassNameInJson() {
		return hideClassNameInJson;
	}

	public void setHideClassNameInJson(Locality hideClassNameInJson) {
		this.hideClassNameInJson = hideClassNameInJson;
	}


}
