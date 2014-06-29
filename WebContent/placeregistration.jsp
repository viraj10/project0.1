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
<div class="container"><div class="row">
<div class="span12">
<h2>&nbsp;</h2>
</div>



<div class="span9 maincontainerspan">
	
<div class="box">
<h4 class="notice-title">Registration for your beautiful place</h4>
<div class="notice">

<form class="form-horizontal" id="registrationPlaceForm" action="saveNewPlace.action" method="post">
	   <div class="control-group">
		<label class="control-label required" for="regPlaceName">Name</label>
		<div class="controls">
		  <input type="text" name="regPlaceName" id="regPlaceName" placeholder="Place name" class="validate['required']"/>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regPlacePhone">Phone</label>
		<div class="controls">
		  <input type="text" name="regPlacePhone" id="regPlacePhone" placeholder="Phone number to contact" class="validate['required']"/>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regPlaceAddress">Address</label>
		<div class="controls">
		  <textarea name="regPlaceAddress" id="regPlaceAddress" class="validate['required']" placeholder="Address to contact"> </textarea>
		</div>
	  </div>
	   <div class="control-group">
		<label class="control-label required" for="regPlacePostcode">Postcode</label>
		<div class="controls">
		  <input type="text" name="regPlacePostcode" id="regPlacePostcode" placeholder="Postcode of place" value="">	  
		<span id="postcodestatus"></span>	
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceLocality">Locality</label>
		<div class="controls">
		  <input type="text" name="regPlaceLocality" id="regPlaceLocality" placeholder="Locality" class="validate['required']"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPriceSlider">Price Range</label>
		<div class="controls">
			<b>5K</b>&nbsp;<input type="text" class="span4 bootstrapslider" value="" data-slider-min="5" data-slider-max="1000" data-slider-step="5" data-slider-value="[250,450]" id="sl2" >&nbsp;<b>1000K</b>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceAC">Air Conditioned</label>
		<div class="controls">
			<input type="checkbox" name="regPlaceAC" id="regPlaceAC"  class="validate['required']" style="width:20px;height:15px;"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlacePower">Power Backup</label>
		<div class="controls">
			<input type="checkbox" name="regPlacePower" id="regPlacePower"  class="validate['required']" style="width:20px;height:15px;"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceMusic">Music allowed</label>
		<div class="controls">
			<input type="checkbox" name="regPlaceMusic" id="regPlaceMusic"  class="validate['required']" style="width:20px;height:15px;"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceVegetarian">Only vegetarian</label>
		<div class="controls">
			<input type="checkbox" name="regPlaceVegetarian" id="regPlaceVegetarian"  class="validate['required']" style="width:20px;height:15px;"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceCapacity">Capacity(in numbers)</label>
		<div class="controls">
		  <input type="text" name="regPlaceCapacity" id="regPlaceCapacity" placeholder="Enter number" class="validate['required']"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceDinning">Dinning Capacity(in numbers)</label>
		<div class="controls">
		  <input type="text" name="regPlaceDinning" id="regPlaceDinning" placeholder="Enter number" class="validate['required']"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceArea">Area(in sq. feet)</label>
		<div class="controls">
		  <input type="text" name="regPlaceArea" id="regPlaceArea" placeholder="Enter sq. feet" class="validate['required']"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceWater">Water Available(in liters)</label>
		<div class="controls">
		  <input type="text" name="regPlaceWater" id="regPlaceWater" placeholder="Enter liters" class="validate['required']"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceParking">Parking(in sq. feet)</label>
		<div class="controls">
		  <input type="text" name="regPlaceParking" id="regPlaceParking" placeholder="Enter sq. feet" class="validate['required']"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceRestRooms">Inbuilt RestRooms(in numbers)</label>
		<div class="controls">
		  <input type="text" name="regPlaceRestRooms" id="regPlaceRestRooms" placeholder="Enter number" class="validate['required']"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceBathrooms">Inbuilt Bathrooms(in numbers)</label>
		<div class="controls">
		  <input type="text" name="regPlaceBathrooms" id="regPlaceBathrooms" placeholder="Enter number" class="validate['required']"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceType">Place Type</label>
		<div class="controls">
		  <input type="checkbox" name="regPlaceMarriage" id="regPlaceMarriage"  class="validate['required']" style="width:20px;height:15px;"/>Marriage Hall
		  <input type="checkbox" name="regPlaceConference" id="regPlaceConference"  class="validate['required']" style="width:20px;height:15px;"/>Conference Hall
		  <input type="checkbox" name="regPlacepartyHall" id="regPlacepartyHall"  class="validate['required']" style="width:20px;height:15px;"/>Party Place
		  <input type="checkbox" name="regPlaceHotel" id="regPlaceHotel"  class="validate['required']" style="width:20px;height:15px;"/>Hotel
		  <input type="checkbox" name="regPlaceOpenHouse" id="regPlaceOpenHouse"  class="validate['required']" style="width:20px;height:15px;"/>Open House
		</div>
	  </div>
	  
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceIndexImg">Main Image Path</label>
		<div class="controls">
		 	<input type="file" data-filename-placement="inside" name="regPlaceIndexImg" id="regPlaceIndexImg"  class="validate['required']"/>
		 </div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceImage1">Additional Image 1</label>
		<div class="controls">
		 	<input type="file" data-filename-placement="inside" name="regPlaceImage1" id="regPlaceImage1"/>
		 </div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceImage2">Additional Image 2</label>
		<div class="controls">
		 	<input type="file" data-filename-placement="inside" name="regPlaceImage2" id="regPlaceImage2" />
		 </div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceImage3">Additional Image 3</label>
		<div class="controls">
		 	<input type="file" data-filename-placement="inside" name="regPlaceImage3" id="regPlaceImage3"/>
		 </div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceImage4">Additional Image 4</label>
		<div class="controls">
		 	<input type="file" data-filename-placement="inside" name="regPlaceImage4" id="regPlaceImage4"/>
		 </div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceDocument">Place Document</label>
		<div class="controls">
		 	<input type="file" data-filename-placement="inside" name="regPlaceDocument" id="regPlaceDocument"/>
		 </div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceMap">Google Map Link</label>
		<div class="controls">
		 	<input type="text" placeholder="Enter URL" name="regPlaceMap" id="regPlaceMap"/>
		 </div>
	  </div>
	  
	  
	  <div class="control-group">
		<div class="controls">
				  <button type="submit" class="btn btn-success">Register</button>
		</div>
	  </div>
	  <div class="" style="text-align:center;">When you login with your email id and password you can modify details entered.</div>
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
    <script src="bootstrap/js/jquery.validate.min.js"></script>	
    <script src="bootstrap/slider/js/bootstrap-slider.js"></script>	
    
</body>
</html>
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
                	regPlaceName:{required:true} ,
                	regPlacePhone:{required:true,allowOnlyNumbers:true,minlength: 10} , 
                	regPlacePostcode:{required:true} , 
                	regPlaceAddress:{required:true} ,
                	regPlaceLocality:{required:true} ,
                	regPlaceCapacity:{required:true,allowOnlyNumbers:true,maxlength: 5} ,
                	regPlaceDinning:{required:true,allowOnlyNumbers:true,maxlength: 4} ,
                	regPlaceArea:{required:true,allowOnlyNumbers:true,maxlength: 5} , 
                	regPlaceWater:{required:true,allowOnlyNumbers:true,maxlength: 5} ,
                	regPlaceParking:{required:true,allowOnlyNumbers:true,maxlength: 4} ,
                	regPlaceRestRooms:{required:true,allowOnlyNumbers:true,maxlength: 3},
                	regPlaceBathrooms:{required:true,allowOnlyNumbers:true,maxlength: 3},
                	regPlaceIndexImg:{required:true}
					
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
  