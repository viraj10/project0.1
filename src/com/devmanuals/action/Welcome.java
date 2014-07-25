package com.devmanuals.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;

public class Welcome extends ActionSupport {
	
	@Override
	public String execute(){
		return Action.SUCCESS;
	}

}
