package com.getbestplace.action;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class LogOutUser extends ActionSupport implements SessionAware{


	private static final long serialVersionUID = 319064503378617301L;
	SessionMap<String, Object> sessionmap;
	@Override
	public void setSession(Map<String, Object> map) {
		sessionmap=(SessionMap<String, Object>)map;
	}
	
	@Override
	public String execute(){
		sessionmap.invalidate();
		return Action.SUCCESS;
	}

}
