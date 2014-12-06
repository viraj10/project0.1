package com.getbestplace.action.search;

import org.apache.log4j.Logger;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class SearchMainJspRender extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1517080581697013396L;
	static final Logger LOGGER = Logger.getLogger(SearchMainJspRender.class);
	
	private String city , locality , name;
	
	@Override
	public String execute(){
		LOGGER.info("inside jsp render "+city + locality + name);
		return Action.SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocality() {
		return locality;
	}

	public void setLocality(String locality) {
		this.locality = locality;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
