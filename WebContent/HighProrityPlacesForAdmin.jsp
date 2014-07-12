<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>The Bombay Tiffin Club - Fine Indina food takeaway</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	 <meta name="keywords" content="book hall, party place,organize event">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link href="bootstrap/css/main.css" rel="stylesheet" type="text/css">
	<link href="bootstrap/css/font-awesome.css" rel="stylesheet" type="text/css">
	<!--[if IE 7]>
	  <link rel="stylesheet" href="themes/bootstrap/css/font-awesome-ie7.css">
	<![endif]-->
    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->
    <!-- Le fav and touch icons -->
    <link rel="shortcut icon" href="favicon.ico">
  </head>
<body>
<script type="text/javascript">
/*   var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-40557475-1']);
  _gaq.push(['_trackPageview']);
  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })(); */
</script><div class="navbar navbar-fixed-top">
      <div class="navbar-inner">
        <div class="container">
          <div class="nav-collapse collapse">
		   <ul class="nav">
				<li><a href="index.php"> <i class="icon-home"></i> Home </a></li>
			</ul>
			
            <ul class="nav pull-right">
				<!--li><a href="#" style="padding:0 14px; "><span class="btn btn-warning">Menu</span></a></li-->
				<c:choose>
					<c:when test="${sessionScope.currentUser!=null && sessionScope.currentUser.userId>0}">
						<li><a href="#">Register my place</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#">Log in </a> </li>	
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
	<div class="span4 pull-right">
		<a class="txtRaling" href="tel:8087781909"><i class="icon-phone"></i> 808-778-1909</a>
	</div>	
</div>	
</div>	
</header>
<div id="bodySection">
<div class="container"><div class="row">
<div class="span12">
<h2>&nbsp;</h2>
</div>


<div class="span6">
<div class="box">
<h4 class="notice-title">Admin Member</h4>
<div class="notice">
<div class="alert alert-danger" id="result1" style="display:none"><span id="result"></span></div>
<form name="loginfrm" class="form-horizontal" id="loginfrm" enctype="" action="addHighPriorityPlace.action" method="post">
		<div class="control-group">
			<label class="control-label" for="placeid">Place id<span style="color: #c30">*</span></label>
			<div class="controls">
			  <input type="text" name="placeid" id="placeid" class="span3 validate['required']" value="" title="placeid"/>
			  <input name="action" id="action" value="login" type="hidden"/>
			</div>
		</div>
	  
	   <div class="control-group">
			<label class="control-label" for="status">Status<span style="color: #c30">*</span></label>
			<div class="controls">
			  <input type="text" name="status" id="status" class="span3 validate['required']" title="status"/>
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
			 <input type="submit" value="Login" class="btn btn-success submit" name="submit" id="submit" />
			</div><br/>
		</div>
</form>
</div>
</div>


</div>

</div>	


</div><!-- /container -->
</div>
 <!-- Button to trigger modal -->
<!--div id="cartInfo">
	<a href="check_out.php" class="btn btn-success" >[ <span class="simpleCart_quantity"></span> ] Items</a>
	<a class="btn" href="menu.php">Menu</a>
	<a class="btn btn-warning" href="check_out.php">Checkout <span class="simpleCart_grandTotal">0</span></a>
</div-->


</div><!-- /wrapper -->
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
		<a href="#"> HOME</a> | 
		<a href="#">TOP PLACES</a> | 
		<a href="#">LOGIN </a> | 	
		<a href="#">REGISTER PACE </a> |  
		<a href="#"> ABOUT US</a>
	</div>
		
		<div>
		&copy; Copyright © 2014  The Superb Developers
		<a href="#">Terms and condition</a><br/>
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
</body>
</html>
<script type="text/javascript">


(function($,W,D)
{
    var JQUERY4U = {};

    JQUERY4U.UTIL =
    {
        setupFormValidation: function()
        {
            //form validation rules
            $("#loginfrm").validate({
                rules: {				
                	placeid: {
						required:true
					},
					status: {
                        required: true
                    }
                },
				
                messages: {
                	placeid: "Please enter a valid id",
                	status: {
                        required: "Please provide a status"
                    }
                  
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });
            
                    }
    }

    //when the dom has loaded setup form validation rules
    $(D).ready(function($) {
        JQUERY4U.UTIL.setupFormValidation();
    });

})(jQuery, window, document);
</script>
  