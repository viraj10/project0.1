package com.getbestplace.resultTypes;

import java.io.PrintWriter;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.Result;
import com.opensymphony.xwork2.util.ValueStack;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

import org.apache.log4j.Logger;

public class JSONResult implements Result {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1623614711866536951L;
	public static final String DEFAULT_PARAM = "classAlias";
	String classAlias;
	static final Logger LOGGER = Logger.getLogger(JSONResult.class);
	
	
	public String getClassAlias() {
		return classAlias;
	}
	
	public void setClassAlias(String classAlias) {
		this.classAlias = classAlias;
	}
	
	public void execute(ActionInvocation invocation) throws Exception {
		
		
		ServletActionContext.getResponse().setContentType("text/plain");
		PrintWriter responseStream =ServletActionContext.getResponse().getWriter();
		ValueStack valueStack = invocation.getStack();
		Object jsonModel = valueStack.findValue("jsonModel");
		Object hideClassNameInJson=valueStack.findValue("hideClassNameInJson");
		XStream xstream = new XStream(new JettisonMappedXmlDriver());
		
		if ( classAlias == null ){
			classAlias = "object";
		}
		LOGGER.info("**** inside jsonresult****"+hideClassNameInJson.toString());
		if(hideClassNameInJson!=null){
			xstream.alias(classAlias, hideClassNameInJson.getClass() );
		}
		responseStream.println(xstream.toXML( jsonModel ));
	}
}
