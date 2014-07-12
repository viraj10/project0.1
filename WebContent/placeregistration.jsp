<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:include value="header.jsp"/>
<body>
<s:include value="bodyHeader.jsp"/>
<div id="bodySection">
<div class="container"><div class="row">
<div class="span12">
<h2>&nbsp;</h2>
</div>



<div class="span9 maincontainerspan">
	
<div class="box">
<h4 class="notice-title">Registration for your beautiful place</h4>
<div class="notice">

<form class="form-horizontal" id="registrationPlaceForm" action="saveNewPlace.action" method="post" enctype="multipart/form-data">
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
		<label class="control-label required" for="regPlaceACVis">Air Conditioned</label>
		<div class="controls">
			<input type="checkbox" name="regPlaceACVis" id="regPlaceACVis"  class="validate['required']" style="width:20px;height:15px;"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlacePowerVis">Power Backup</label>
		<div class="controls">
			<input type="checkbox" name="regPlacePowerVis" id="regPlacePowerVis"  class="validate['required']" style="width:20px;height:15px;"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceMusicVis">Music allowed</label>
		<div class="controls">
			<input type="checkbox" name="regPlaceMusicVis" id="regPlaceMusicVis"  class="validate['required']" style="width:20px;height:15px;"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceVegetarianVis">Only vegetarian</label>
		<div class="controls">
			<input type="checkbox" name="regPlaceVegetarianVis" id="regPlaceVegetarianVis"  class="validate['required']" style="width:20px;height:15px;"/>
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
		  <input type="checkbox" name="regPlaceMarriageVis" id="regPlaceMarriageVis"  class="validate['required']" style="width:20px;height:15px;"/>Marriage Hall
		  <input type="checkbox" name="regPlaceConferenceVis" id="regPlaceConferenceVis"  class="validate['required']" style="width:20px;height:15px;"/>Conference Hall
		  <input type="checkbox" name="regPlacepartyHallVis" id="regPlacepartyHallVis"  class="validate['required']" style="width:20px;height:15px;"/>Party Place
		  <input type="checkbox" name="regPlaceHotelVis" id="regPlaceHotelVis"  class="validate['required']" style="width:20px;height:15px;"/>Hotel
		  <input type="checkbox" name="regPlaceOpenHouseVis" id="regPlaceOpenHouseVis"  class="validate['required']" style="width:20px;height:15px;"/>Open House
		</div>
	  </div>
	  
	  
	  <div class="control-group">
		<label class="control-label required" for="regPlaceIndexImg">Main Image Path</label>
		<div class="controls">
		 	<!-- input type="file" data-filename-placement="inside" name="regPlaceIndexImg" id="regPlaceIndexImg"  class=""/-->
		 	<s:file name="indexFile" size="10"/>
		 </div>
		 
	  </div>
	  
	  <div class="control-group">
		<label class="control-label" for="regPlaceImage1">Additional Image 1</label>
		<div class="controls">
		 	<s:file name="add1File" size="10"/>
		 </div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label" for="regPlaceImage2">Additional Image 2</label>
		<div class="controls">
			<s:file name="add2File" size="10"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label" for="regPlaceImage3">Additional Image 3</label>
		<div class="controls">
			<s:file name="add3File" size="10"/>
		</div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label" for="regPlaceImage4">Additional Image 4</label>
		<div class="controls">
		 	<s:file name="add4File" size="10"/>
		 </div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label" for="regPlaceDocument">Place Document</label>
		<div class="controls">
		 	<s:file name="packageFile" size="10"/>
		 </div>
	  </div>
	  
	  <div class="control-group">
		<label class="control-label" for="regPlaceMap">Google Map Link</label>
		<div class="controls">
		 	<input type="text" placeholder="Enter URL" name="regPlaceMap" id="regPlaceMap"/>
		 </div>
	  </div>
	  
	  <input name="regPlaceMinPrice" id="regPlaceMinPrice" type="hidden"/>
	  <input name="regPlaceMaxPrice" id="regPlaceMaxPrice" type="hidden"/>
	  
	  <input name="regPlacePower" id="regPlacePower" type="hidden"/>
	  <input name="regPlaceMusic" id="regPlaceMusic" type="hidden"/>
	  <input name="regPlaceVegetarian" id="regPlaceVegetarian" type="hidden"/>
	  <input name="regPlaceAC" id="regPlaceAC" type="hidden"/>
	  
	  <input name="regPlaceMarriage" id="regPlaceMarriage" type="hidden"/>
	  <input name="regPlaceConference" id="regPlaceConference" type="hidden"/>
	  <input name="regPlacepartyHall" id="regPlacepartyHall" type="hidden"/>
	  <input name="regPlaceHotel" id="regPlaceHotel" type="hidden"/>
	  <input name="regPlaceOpenHouse" id="regPlaceOpenHouse" type="hidden"/>
	  
	  <div class="control-group">
		<div class="controls">
				  
				   <s:submit value="Upload" align="center" />
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
<s:include value="footer.jsp"/>
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
                	var priceArray=$(".bootstrapslider").data('slider').getValue();
                	$("#regPlaceMinPrice").val(priceArray[0]);
                	$("#regPlaceMaxPrice").val(priceArray[1]);
                	
                	$("#regPlacePower").val($("#regPlacePowerVis").prop('checked'));
	              	$("#regPlaceMusic").val($("#regPlaceMusicVis").prop('checked'));
	              	$("#regPlaceVegetarian").val($("#regPlaceVegetarianVis").prop('checked'));
	              	$("#regPlaceAC").val($("#regPlaceACVis").prop('checked'));
	              	$("#regPlaceMarriage").val($("#regPlaceMarriageVis").prop('checked'));
	              	$("#regPlaceConference").val($("#regPlaceConferenceVis").prop('checked'));
	              	$("#regPlacepartyHall").val($("#regPlacepartyHallVis").prop('checked'));
	              	$("#regPlaceHotel").val($("#regPlaceHotelVis").prop('checked'));
	              	$("#regPlaceOpenHouse").val($("#regPlaceOpenHouseVis").prop('checked'));
                	              	  
	              
              	
                	
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
  