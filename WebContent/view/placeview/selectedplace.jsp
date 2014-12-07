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
<div id="bodySection">
	<div class="container">
		<div class="row">
			<div class="span12 ">
				<h2 class="selected-place-name"><s:property value="place.name"/></h2>
				<div class="selected-place-images row">
					<div class="big-image row">
						<img src="http://localhost:8080/StrutsHelloWorld/places/pune/Aundh/test5/Sign.jpg" id="big-image-tag"/>
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
				<div><s:property value="place.address"/></div>
				<s:iterator value="place.attributes">
					<div>
					<s:property value="attributeName"/>
					<s:property value="stringValue"/>
					<s:property value="doubleValue"/>
					<s:property value="intValue"/>
					</div>
				</s:iterator>		
			</div>
		</div>		
	</div><!-- /container -->
</div>


</div><!-- /wrapper -->
<s:include value="/view/partailview/footer.jsp"/>
<script type="text/javascript">


$( document ).ready(function() {

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