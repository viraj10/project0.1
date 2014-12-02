<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:include value="/view/partailview/header.jsp"/>
<body>
<s:include value="/view/partailview/bodyHeader.jsp"/>
<div id="bodySection">
<div class="container">

	<form action="" method="post" style="margin-bottom:0;overflow:hidden;">									
		<h2 id="searchBoxWrapper">
			<div id="postCodeInner" style="text-align: center;">
				<input class="span3" id="city" name="city" type="text" placeholder="CITY"/>
				<input class="span3" id="location" name="location" type="text" placeholder="LOCATION"/>
				<input class="span3" id="name" name="name" type="text" placeholder="NAME"/>
				<button class="btn btn-large btn-success" type="submit" style="margin-bottom: 7px;">SEARCH</button>
			</div>
		</h2>
	</form>
	<div class="row">
		<div class="span3 ">
			<div class="search-sort-box">
				<label class="control-label" for="regPriceSlider">Price Range</label>
			</div>
			<div class="search-sort-box">
				<label class="control-label" for="regPriceSlider">Place Type</label>
			</div>
			<div class="search-sort-box">
				<label class="control-label" for="regPriceSlider">Capacity</label>	
			</div>
			<div class="search-sort-box">
				<label class="control-label" for="regPriceSlider">Air Conditioned</label>	
			</div>
			<div class="search-sort-box">
				<label class="control-label" for="regPriceSlider">Music</label>	
			</div>			
		</div>
		<div class="span9">
		
		</div>
	</div>
		
</div><!-- /container -->
</div>


</div><!-- /wrapper -->
<s:include value="/view/partailview/footer.jsp"/>
<script type="text/javascript">


$( document ).ready(function() {
	
	/*$.ajax({
		url:'getHighPriorityPlace',
		type:'POST',
		async:false, 
		success:function(jsonResponse) {                			
			 
			console.log(jsonResponse);
		}
	});*/
	
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