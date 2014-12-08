<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Footer
================================================== -->
<footer class="footer">
	<div class="container"><br>
	<ul class="followUs">
		<li><a class="mail" href="" title="Email"></a></li>
		<li><a class="facebook qtip" href="https://www.facebook.com/" target="_blank" title="facebook"></a></li>
		<li><a class="twitter" href="https://twitter.com/" target="_blank" title="Twitter"></a></li>
		<li><a class="dribble qtip" href="https://plus.google.com/" title="Google plus" target="_blank"></a></li>
	</ul>
	<div id="footerMenu">
		<a href="welcome"> HOME</a> | 
		<a href="#">TOP PLACES</a> | 
		<c:choose>
			<c:when test="${sessionScope.currentUser!=null && sessionScope.currentUser.userId>0}">
				<a href="logoutuser">LOGOUT </a> | 
				<a href="registerplace">REGISTER PLACE </a> |  
			</c:when>
			<c:otherwise>
				<a href="loginresgister">LOGIN </a> | 
			</c:otherwise>
		</c:choose>
		<a href="welcome"> ABOUT US</a>
	</div>
		
		<div>
		&copy; Copyright © 2014  The Superb Developers
		<a href="#">No Terms and condition</a><br/>
		<small>Developed by <br>Exciting People.</small>
		</div>
		
		<br>
		<br>
		<br>

	 </div>
</footer>

    <!-- Le javascript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="bootstrap/js/jquery-1.8.3.min.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!--script src="bootstrap/js/smart.js"></script>
    <script src="bootstrap/js/simpleCart.js"></script>
    <script src="bootstrap/js/bombaytiffinclub.js"></script-->	
    <script src="bootstrap/js/jquery.validate.min.js"></script>	
    <script src="bootstrap/js/jquery.validate.min.js"></script>	
    <script src="bootstrap/slider/js/bootstrap-slider.js"></script>	
    


</body>