<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <div class="nav-collapse collapse">
		   <ul class="nav">
				<li><a href="welcome"> <i class="icon-home"></i> Home </a></li>
			</ul>
			
            <ul class="nav pull-right">
				<!--li><a href="#" style="padding:0 14px; "><span class="btn btn-warning">Menu</span></a></li-->
				<c:choose>
					<c:when test="${sessionScope.currentUser!=null && sessionScope.currentUser.userId>0}">
						<li><a href="registerplace">Register my place</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="loginresgister">Log in/Register </a> </li>	
					</c:otherwise>              
				</c:choose>
				<li><a href="#" style="padding:0 14px; " title="Know the most booked places here.">
					<span class="btn btn-success"><i class="icon-shopping-cart"></i> Top places </span> 
				</a></li>	
			</ul>
		
        </div>
      </div>
</div>	
</div>	
<div class="wrapper">
<header class="header">
<div class="container">
<div class="row">
	<div class="span4">
		<h1><a id="logo" href="#"><img src="logo.png" alt="#"/></a></h1>
	</div>
	<!--div class="span4">
		<h1><a id="menuBtn" href="menu.php"><img src="bootstrap/img/menu_btn.png" alt="20% off on order online"/></a></h1>
	</div-->
	<div class="span5 pull-right" style="text-align:right">
		<a class="txtRaling" href="tel:8087781909"><i class="icon-phone"></i> 808-778-1909</a>
	</div>	
</div>	
</div>	
</header>