<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <title>The Bombay Tiffin Club - Fine Indina food takeaway</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	 <meta name="keywords" content="book hall, party place,organize event">
    <link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet"/>
	<link href="bootstrap/css/main.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/font-awesome.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/css/placeregistration.css" rel="stylesheet" type="text/css"/>
	<link href="bootstrap/slider/css/slider.css" rel="stylesheet" type="text/css"/>	
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

<div class="navbar navbar-fixed-top">
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
	<div class="span5 pull-right">
		<a class="txtRaling" href="tel:8087781909"><i class="icon-phone"></i> 808-778-1909</a>
	</div>	
</div>	
</div>	
</header>
<div id="bodySection">
<div class="container">

<div id="myCarousel" class="carousel slide">
   <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1" class=""></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>
  <!-- Carousel items -->
  <div class="carousel-inner">
    <div class="item active"><p><img src="places/pune/beautifulplace/1.png" alt="bootstrappage"></p></div>
    <div class="item"><p><img src="places/pune/beautifulplace/2.png" alt="bootstrappage"></p></div>
  	<div class="item"><p><img src="places/pune/beautifulplace/3.jpg" alt="bootstrappage"></p></div>
  
  </div>
  <!-- Carousel nav -->
  <a class="carousel-control left" href="#myCarousel" data-slide="prev">‹</a>
  <a class="carousel-control right" href="#myCarousel" data-slide="next">›</a>
</div>

	<form action="distance.php" method="post" style="margin-bottom:0">
									
		<h2 id="postCodeWrapper">
			<div id="postCodeInner">
				<span class="wTxt">Search Place: </span>
				<input class="span3" id="postcode" name="postcode" type="text" placeholder="eg. W6 0SP">
				<input class="span3" id="postcode" name="postcode" type="text" placeholder="eg. W6 0SP">
				<input class="span3" id="postcode" name="postcode" type="text" placeholder="eg. W6 0SP">
				<button class="btn btn-large btn-success" type="submit">CHECK SERVICES</button>
			</div>
		</h2>
	</form>
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
    <script src="bootstrap/js/jquery.validate.min.js"></script>	
    <script src="bootstrap/slider/js/bootstrap-slider.js"></script>	
    


</body>
<script type="text/javascript">


(function($,W,D)
{
    var JQUERY4U = {};
    $('.bootstrapslider').slider();
    JQUERY4U.UTIL =
    {
        setupFormValidation: function()
        {
            //form validation rules
            
            jQuery.validator.addMethod("allowOnlyNumbers", function(value, element) {
            	  
            	return /[0-9\.]/.test(value)
            }, "This field can contain only number(s).");
			
            
                      
			$("#registrationPlaceForm").validate({
                rules: {	
                		
                },				
                messages: {
                 
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
  
</html>

