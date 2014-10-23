package com.getbestplace.interceptors;

import java.util.Map;

import com.getbestplace.model.User;
import com.getbestplace.util.UserAware;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9206905277938840537L;

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation ai) throws Exception {
		Map session = ai.getInvocationContext().getSession();
		User user=(User)session.get("currentUser");//now this should not be hard coded .
		Action action=(Action)ai.getAction();
		
		if(action instanceof UserAware){
			if(user==null){
				return Action.LOGIN;
			}else{
				((UserAware) action).setUser(user);
				return ai.invoke();
			}
		}else{
			return ai.invoke();
		}
		
	}
	


}
