<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
				<li><a href="#">Register my place</a></li>
				<li><a href="#">Log in </a> </li>	
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
<h4 class="notice-title">Existing Member</h4>
<div class="notice">
<div class="alert alert-danger" id="result1" style="display:none"><span id="result"></span></div>
<form name="loginfrm" class="form-horizontal" id="loginfrm" enctype="" action="" method="post">
		<div class="control-group">
			<label class="control-label" for="email">Email<span style="color: #c30">*</span></label>
			<div class="controls">
			  <input type="email" name="username" id="username" class="span3 validate['required','email']" value="" title="Email address"/>
			  <input name="action" id="action" value="login" type="hidden"/>
			</div>
		</div>
	  
	   <div class="control-group">
			<label class="control-label" for="password">Password<span style="color: #c30">*</span></label>
			<div class="controls">
			  <input type="password" name="password" id="password" class="span3 validate['required']" title="Password"/>
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
			 <input type="submit" value="Login" class="btn btn-success submit" name="submit" id="submit" /> <a href="#" class="forgot-password">Forgot your password?</a>
			<br/>
			</div><br/>
		</div>
	</form>
</div>
</div>


</div>
<div class="span6">
	
<div class="box">
<h4 class="notice-title">Registration for New Member</h4>
<div class="notice">

<form class="form-horizontal" id="registrationForm" action="saveNewUser.action" method="post">
	   <div class="control-group">
		<label class="control-label required" for="regName">Name</label>
		<div class="controls">
		  <input type="text" name="userbean.userName" id="regName" placeholder="Name" class="validate['required']"/>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regUserPhone">Phone</label>
		<div class="controls">
		  <input type="text" name="userbean.phone" id="regUserPhone" placeholder="Phone" class="validate['required']"/>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label" for="regInputAddress">Address</label>
		<div class="controls">
		  <textarea name="userbean.address" id="regInputAddress"> </textarea>
		</div>
	  </div>
	   <div class="control-group">
		<label class="control-label required" for="regInputPostcode">Postcode</label>
		<div class="controls">
		  <input type="text" name="userbean.postalCode" id="regInputPostcode" placeholder="Postcode" value="">	  
		<span id="postcodestatus"></span>	
		</div>
	  </div>
	   <div class="control-group">
		<label class="control-label required" for="regInputCity">City</label>
		<div class="controls">
		  <input type="text" name="userbean.city" id="regInputCity" placeholder="City" class="validate['required']"/>
		</div>
	  </div>


	  <div class="control-group">
		<label class="control-label required" for="regInputEmail">Email</label>
		<div class="controls">
		  <input type="text" name="userbean.email" id="regInputEmail" placeholder="Email" class="validate['required','email']"/>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regInputPassword">Password</label>
		<div class="controls">
		  <input type="password" name="userbean.password" id="regInputPassword" placeholder="Password" class="validate['required']"/>
		  <input type="hidden" name="reg" value="1">
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regInputConfirmPassword">Confirm Password</label>
		<div class="controls">
		  <input type="password" name="regInputConfirmPassword" id="regInputConfirmPassword" placeholder="Confirm Password" class="validate['required']"/>
		  <input type="hidden" name="reg" value="1">
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regInputCaptcha"><img src=" <s:url action='getCaptcha?imageId=captcha.png' />" /></label>
		<div class="controls">
		  <input type="text" name="regInputCaptcha" id="regInputCaptcha" placeholder="Enter the text here" class="validate['required']"/>
		</div>
	  </div>	  
	  <div class="control-group">
		<div class="controls">
				  <button type="submit" class="btn btn-success">Register</button>
		</div>
	  </div>
	  <div class="" style="text-align:center;">Your email id will be used as username.</div>
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
					username: {
						required:true,
						email:true
					},
                    password: {
                        required: true,
                        minlength: 5
                    }
                },
				
                messages: {
                    username: "Please enter a valid email address",
                    password: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },
                  
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });
			
			$("#registrationForm").validate({
                rules: {	
					regName:{required:true},
					regUserPhone:{
						required:true,
						minlength: 10
					},
					regInputAddress:{required:true},
					regInputPostcode:{required:true},
					regInputCity:{required:true},
					regInputEmail:{
						required:true,
						email:true
					},
					regInputPassword:{
						required: true,
                        minlength: 6
					},
					regInputConfirmPassword:{
					required:true,
					equalTo:'#regInputPassword'
					}
					/*username: {
						required:true,
						email:true
					},
                    password: {
                        required: true,
                        minlength: 5
                    }*/
                },
				
                messages: {
                    /*username: "Please enter a valid email address",
                    password: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },*/
					
					regName: "Please provide a name.",
					regUserPhone: {
						required:"Please provide a phone.",
						minlength:"Minimum of 10 digits."
					},
					regInputAddress: "Please provide a address.",
					regInputPostcode: "Please provide a postcal code.",
					regInputCity: "Please provide a city.",
					regInputEmail:{
						required: "Please provide a email.",
						email: "Please provide valid email."
					},
					regInputPassword:{
						required: "Please provide a password.",
                        minlength: "Minimum length of password is 6.",
					},
					regInputConfirmPassword:{
						required: "Please provide a password.",
						equalTo: "Please enter text same as password.",
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
  