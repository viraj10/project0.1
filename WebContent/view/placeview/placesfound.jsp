<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="searched-places-conatiner">
	<s:iterator value="places" status="status">
	Index: <s:property value="%{#status.index}" /> <br />
		<div class="place-box">
			<s:property value="name"/>
			<s:property value="locality"/>
			<s:property value="postalCode"/>
			iterator value="attributes"
				property value="attributeName"
			iterator
		</div>
	</s:iterator>
</div>
