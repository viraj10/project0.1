<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:include value="header.jsp"/>
<body>
<s:include value="bodyHeader.jsp"/>
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
				<input class="span3" id="city" name="city" type="text" placeholder="CITY"/>
				<input class="span3" id="location" name="location" type="text" placeholder="LOCATION"/>
				<input class="span3" id="name" name="name" type="text" placeholder="NAME"/>
				<button class="btn btn-large btn-success" type="submit">SEARCH</button>
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
<s:include value="footer.jsp"/>
<script type="text/javascript">


$( document ).ready(function() {
	
	$.ajax({
		url:'getHighPriorityPlace.action',
		type:'POST',
		async:false, 
		success:function(jsonResponse) {                			
			 
			console.log(jsonResponse);
		}
	});
	
});

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