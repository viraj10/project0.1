<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="searched-places-contianer">
	<s:iterator value="places" status="status">
		<div class="place-box">
			<span class="place-name-box float-left"><a href="selectedplace?placeName=<s:property value="name"/>"><s:property value="name"/></a></span>
			<span class="place-locality-box"><a href=""><s:property value="locality"/><a></a></span>
			<span class="place-phone-box float-right"><i class="icon-phone"></i>&nbsp;&nbsp;<s:property value="phone"/></span>
			<!-- iterator value="attributes"
				property value="attributeName"
			iterator -->
		</div>
	</s:iterator>
</div>
