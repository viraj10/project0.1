<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:include value="/view/partailview/header.jsp"/>
<body>
<s:include value="/view/partailview/bodyHeader.jsp"/>
<div id="bodySection">
	<div class="container">
		<div class="row">
			<div class="span12 ">
				<h2><s:property value="place.name"/></h2>
				<h6><s:property value="place.address"/></h6>
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