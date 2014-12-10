<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:include value="/view/partailview/header.jsp"/>
<style>
.dropdown-menu > li > a{
	font-size:15px !important;
	font-weight:100 !important;
}

</style>
<body>
<s:include value="/view/partailview/bodyHeader.jsp"/>
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
  </div>
  <!-- Carousel nav -->
  <a class="carousel-control left" href="#myCarousel" data-slide="prev">‹</a>
  <a class="carousel-control right" href="#myCarousel" data-slide="next">›</a>
</div>

<form action="searchplace" method="get" style="margin-bottom:0;overflow:hidden;">									
	<h2 id="searchBoxWrapper">
		<div id="postCodeInner" style="text-align: center;">
			<input class="span3" id="city" name="city" type="text" placeholder="CITY" value="Pune" disabled/>
			<input class="span3" id="locality" name="locality" type="text" placeholder="LOCATION" autocomplete="off"/>
			<input class="span3" id="name" name="name" type="text" placeholder="NAME"/>
			<button class="btn btn-large btn-success" type="submit" style="margin-bottom: 7px;">SEARCH</button>
		</div>
	</h2>
</form>
	
	
	<div class="row">
		<div class="span2" style="border:1px solid black;"><p>1</p></div>

		<div class="span2" style="border:1px solid black;"><p>2</p></div>

		<div class="span2" style="border:1px solid black;"><p>3</p></div>
		
		<div class="span2" style="border:1px solid black;"><p>4</p></div>
		
		<div class="span2" style="border:1px solid black;"><p>5</p></div>
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

</div><!-- /wrapper -->
<s:include value="/view/partailview/footer.jsp"/>
<script type="text/javascript">


$( document ).ready(function() {
	
	$.ajax({
		url:'getHighPriorityPlace',
		type:'POST',
		async:false, 
		success:function(jsonResponse) {                			
			 
			console.log(jsonResponse);
		}
	});
	
	$('.carousel').carousel({
		interval: 3000
	});
	
	$.ajax({
		url:'getLocality',
		type:'POST', 
		data:{citySelected : 'pune'}, 
		success:function(jsonResponse) { 
			var response = jQuery.parseJSON(jsonResponse);
			$( "#locality" ).typeahead({
				source: function(query, process) {
			        objects = [];
			        map = {};
			        var data = response.list.localities
			        $.each(data, function(i, object) {
			            map[object.locality] = object;
			            objects.push(object.locality);
			        });
			        process(objects);
			    },
				items:5
			});
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