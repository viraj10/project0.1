<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:include value="/view/partailview/header.jsp"/>
<style>
.selected-place-name{
	color: #FFCB00;
	border-bottom: 1px solid #d2d2d2;
}
.selected-place-images{
	text-align:center;
	margin: 2% auto;
}
.selected-place-images img{
	width:75px;
	height:75px;
}
#big-image-tag{
	width: 50%;
	height: 200px;
}
.big-image{
	margin:10px auto;
}
</style>
<body>
<s:include value="/view/partailview/bodyHeader.jsp"/>
<s:bean name="com.getbestplace.util.AttributeNameComparator" var="attributeNameComparator" />
<div id="bodySection">
	<div class="container">
		<div class="row">
			<div class="span12 ">
				<h2 class="selected-place-name"><s:property value="place.name"/></h2>
				<div class="selected-place-images row">
					<div class="big-image row">
						<img src="" id="big-image-tag"/>
					</div>
					<s:iterator value="place.attributes">
						<s:if test="%{attributeName=='Index'}">
							<img src="<s:property value="stringValue"/>" id="index-Image" class="place-image"/>
						</s:if>
						<s:if test="%{attributeName=='add1'}">
							<img src="<s:property value="stringValue"/>" id="add1-Image" class="place-image"/>
						</s:if>
						<s:if test="%{attributeName=='add2'}">
							<img src="<s:property value="stringValue"/>" id="add2-Image" class="place-image"/>
						</s:if>
						<s:if test="%{attributeName=='add3'}">
							<img src="<s:property value="stringValue"/>" id="add3-Image" class="place-image"/>
						</s:if>
						<s:if test="%{attributeName=='add4'}">
							<img src="<s:property value="stringValue"/>" id="add4-Image" class="place-image"/>
						</s:if>
					</s:iterator>
				</div>
				<div class="row">
					<div class="span3"><span>Address of this place is </span><b><s:property value="place.address"/></b>.</div>
					<div class="span3"><span>Locality is </span><b><s:property value="place.locality"/></b> in city <b><s:property value="place.city"/></b>.</div>
					<div class="span3"><span>Postal code: </span><b><s:property value="place.postalCode"/></b>.</div>
					<div class="span3"><span>Contact Number: </span><b><s:property value="place.phone"/></b>.</div>
				</div>
				<h3>Other Information about this place.</h3>
				<div class="row">
				<s:sort comparator="#attributeNameComparator" source="place.attributes">
					<s:iterator><s:property value="attributeName"/>
						<div class="span3">
							<s:if test="%{attributeName=='AC'}">
								This place air conditioned:- <s:property value="stringValue"/>.
							</s:if>
							<s:if test="%{attributeName=='Area'}">
								Area of this place:- <s:property value="intValue"/> sq ft.
							</s:if>
							<s:if test="%{attributeName=='BathRooms'}">
								Inbuilt bathrooms:- <s:property value="intValue"/>.
							</s:if>
							<s:if test="%{attributeName=='Capacity'}">
								Capacity of this place:- <s:property value="intValue"/>.
							</s:if>
							<s:if test="%{attributeName=='Conference'}">
								This place has conferences hall:- <s:property value="stringValue"/>.
							</s:if>
							<s:if test="%{attributeName=='Dinning'}">
								One time dining capacity:- <s:property value="intValue"/>.
							</s:if>
							<s:if test="%{attributeName=='Marriage'}">
								This place is a marriage hall:- <s:property value="stringValue"/>.
							</s:if>
							<s:if test="%{attributeName=='MaximumPrice'}">
								Maximum rate of place:- <s:property value="intValue"/>K INR.
							</s:if>
							<s:if test="%{attributeName=='MinimumPrice'}">
								Minimum rate of place:- <s:property value="intValue"/>K INR.
							</s:if>
							<s:if test="%{attributeName=='Music'}">
								Is music allowed:- <s:property value="stringValue"/>.
							</s:if>
							<s:if test="%{attributeName=='OpenHouse'}">
								Is this place with out roof:- <s:property value="stringValue"/>.
							</s:if>
							<s:if test="%{attributeName=='Parking'}">
								How many can park here:- <s:property value="intValue"/>.
							</s:if>
							<s:if test="%{attributeName=='Party'}">
								This place is can hold party:- <s:property value="stringValue"/>.
							</s:if>
							<s:if test="%{attributeName=='Power'}">
								Is there a inbuilt power back up:- <s:property value="stringValue"/>.
							</s:if>
							<s:if test="%{attributeName=='RestRooms'}">
								Inbuilt restrooms:- <s:property value="intValue"/>.
							</s:if>
							<s:if test="%{attributeName=='Water'}">
								Water storage limit:- <s:property value="intValue"/>.
							</s:if>
							<s:if test="%{attributeName=='map'}">
								Map link:- <a><s:property value="stringValue"/></a>.
							</s:if>
							<s:if test="%{attributeName=='vegetarian'}">
								Only vegetarians are allowed? <s:property value="stringValue"/>.
							</s:if>													
						</div>
					</s:iterator>
				</s:sort>		
				</div>
			</div>
		</div>		
	</div><!-- /container -->
</div>


</div><!-- /wrapper -->
<s:include value="/view/partailview/footer.jsp"/>
<script type="text/javascript">


$( document ).ready(function() {	
	function setBigImgSrc(path){
		$('#big-image-tag').attr('src',path);
	}
	
	var indexImg = $('#index-Image').attr('src');
	setBigImgSrc(indexImg);
	$( ".place-image" ).click(function() {
		setBigImgSrc( $(this).attr('src'));
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
            
        }
    }

    //when the dom has loaded setup form validation rules
    $(D).ready(function($) {
        JQUERY4U.UTIL.setupFormValidation();
    });

})(jQuery, window, document);
</script>
</html>