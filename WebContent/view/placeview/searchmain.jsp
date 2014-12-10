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

	<form action="" method="post" style="margin-bottom:0;overflow:hidden;">									
		<h2 id="searchBoxWrapper">
			<div id="postCodeInner" style="text-align: center;">
				<input class="span3" id="city" name="city" type="text" placeholder="CITY" value="Pune" disabled/>
				<s:textfield name="locality" id="locality" cssClass="span3" placeholder="LOCATION" autocomplete="off"/>
				<s:textfield name="name" id="name" cssClass="span3" placeholder="NAME"/>
				<button class="btn btn-large btn-success" type="submit" style="margin-bottom: 7px;">SEARCH</button>
			</div>
		</h2>
	</form>
	<div class="row">
		<div class="span3 ">
			<div class="search-sort-box">
				<label class="control-label" for="regPriceSlider">Price Range of place</label>
				<input id="priceSlider" data-slider-id='ex1Slider' type="text" data-slider-min="0" data-slider-max="500" data-slider-step="10" data-slider-value="250"/>
			</div>
			<div class="search-sort-box">
				<p class="control-label">Place Type</p>
			  	<div class="checkbox">
		          	<label><input type="checkbox" value="">Marriage Hall</label>
		        	<label><input type="checkbox" value="">Conference Hall</label>
		        	<label><input type="checkbox" value="">Party Place</label>
		        	<label><input type="checkbox" value="">Hotel</label>
		        	<label><input type="checkbox" value="">Open House</label>
		        </div>
			</div>
			<div class="search-sort-box">
				<label class="control-label" for="regPriceSlider">Capacity of place</label>	
				<input id="capacitySlider" data-slider-id='ex2Slider' type="text" data-slider-min="0" data-slider-max="5000" data-slider-step="100" data-slider-value="2000"/>
			</div>
			<div class="search-sort-box">
				<p class="control-label">Air Conditioned</p>	
				<div class="radio">
					<label><input type="radio" name="optAC">AC</label>
					<label><input type="radio" name="optAC">Non-AC</label>
				</div>					  	  
			</div>
			<div class="search-sort-box">
				<p>Music must be allowed  :<input type="checkbox" name="music"/></p>
			</div>			
		</div>
		<div class="span9 show-places">
		
		</div>
	</div>
		
</div><!-- /container -->
</div>


</div><!-- /wrapper -->
<s:include value="/view/partailview/footer.jsp"/>
<script type="text/javascript">


$( document ).ready(function() {
	
	$('#priceSlider').slider({
		formatter: function(value) {
			return 'Current value: ' + value;
		}
	});
	$('#capacitySlider').slider({
		formatter: function(value) {
			return 'Current value: ' + value;
		}
	});
	
	$.ajax({
		url:'searchplaces/searchplace',
		type:'POST', 
		dataType : 'html',
		data: {
			locality : $("#locality").val(),
			name: $("#name").val()
        },
		success:function(htmlResponse) {                			
			 $(".show-places").html(htmlResponse);
			 getSelectList();
		}
	});
	/*$("#priceSlider").data('slider').getValue()
	$("#capacitySlider").data('slider').getValue()
	$.ajax({
		url:'getHighPriorityPlace',
		type:'POST',
		async:false, 
		success:function(jsonResponse) {                			
			 
			console.log(jsonResponse);
		}
	});*/
	
});

function getSelectList(){
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
}

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