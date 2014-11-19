package com.getbestplace.action;

import org.apache.log4j.Logger;
import com.opensymphony.xwork2.ActionSupport;

public class SearchPlaceFirst extends ActionSupport{
	
	private static final long serialVersionUID = 1110054598L;
	static final Logger LOGGER = Logger.getLogger(SearchPlaceFirst.class);
	
	private String locality;
	
	@Override
	public String execute(){
		LOGGER.info("we are inside SearchPlaceFirst with locality="+locality);
		return SUCCESS;
	}
	
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}

}
