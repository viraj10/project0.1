<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<s:include value="/view/partailview/header.jsp"/>
<body>
<s:include value="/view/partailview/bodyHeader.jsp"/>
<div id="bodySection">
<div class="container"><div class="row">
<div class="span12">
<h2>&nbsp;</h2>
</div>



<div class="span12">
	
<div class="box">
<h4>We are sorry, something went wrong.</h4>
<h6>Message:<s:property value="%{exception.message}"/></h6>

Stack:<s:property value="%{exceptionStack}"/> 
</div>	
</div>	
</div>	


</div><!-- /container -->
</div>

</div><!-- /wrapper -->
<s:include value="/view/partailview/footer.jsp"/>
<script type="text/javascript">
(function($,W,D)
{

    

   

})(jQuery, window, document);
</script>
  