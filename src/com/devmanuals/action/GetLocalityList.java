package com.devmanuals.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.devmanuals.listener.HibernateListener;
import com.devmanuals.util.JsonUtils;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class GetLocalityList extends ActionSupport implements ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 111001298L;

	private String citySelected;
	
	@Override
	public String execute(){
		
		return SUCCESS;
	}
	
	
	private HttpServletResponse response;
	
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public String getLocalityInCity() throws Exception{
		
		SessionFactory sessionFactory=(SessionFactory) ServletActionContext.getServletContext().getAttribute(HibernateListener.KEY_NAME);
		Session session=sessionFactory.openSession();
		Query queryEmail=session.createQuery("select locality from Locality l where l.city=:city ");
		queryEmail.setParameter("city",getCitySelected());
		List localityList=queryEmail.list();

		response.getWriter().write(JsonUtils.getLocality(localityList));
		response.getWriter().flush();
		session.close();
		return Action.NONE;
	}

	public String getCitySelected() {
		return citySelected;
	}

	public void setCitySelected(String citySelected) {
		this.citySelected = citySelected;
	}


}
