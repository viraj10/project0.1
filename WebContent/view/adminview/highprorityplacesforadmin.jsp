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


<div class="span6">
<div class="box">
<h4 class="notice-title">Please fill the details to add a place</h4>
<div class="notice">
<div class="alert alert-danger" id="result1" style="display:none"><span id="result"></span></div>
<form name="loginfrm" class="form-horizontal" id="loginfrm" enctype="" action="addHighPriorityPlace" method="post">
		<div class="control-group">
			<label class="control-label" for="placeid">Place id<span style="color: #c30">*</span></label>
			<div class="controls">
			  <input type="text" name="placeid" id="placeid" class="span3 validate['required']" value="" title="placeid"/>
			  <input name="action" id="action" value="login" type="hidden"/>
			</div>
		</div>
	  
	   <div class="control-group">
			<label class="control-label" for="status">Status<span style="color: #c30">*</span></label>
			<div class="controls">
			  <input type="text" name="status" id="status" class="span3 validate['required']" title="status"/>
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
			 <input type="submit" value="ADD" class="btn btn-success submit" name="submit" id="submit" />
			</div><br/>
		</div>
</form>
</div>
</div>


</div>

<div class="span6">
<div class="box">
<h4 class="notice-title">Please fill the details to remove  place</h4>
<div class="notice">
<div class="alert alert-danger" id="result1" style="display:none"><span id="result"></span></div>
<form name="loginfrm" class="form-horizontal" id="loginfrm" enctype="" action="removeHighPriorityPlace" method="post">
		<div class="control-group">
			<label class="control-label" for="placeid">Place id<span style="color: #c30">*</span></label>
			<div class="controls">
			  <input type="text" name="placeid" id="placeid" class="span3 validate['required']" value="" title="placeid"/>
			  <input name="action" id="action" value="login" type="hidden"/>
			</div>
		</div>
	  
		<div class="control-group">
			<div class="controls">
			 <input type="submit" value="REMOVE" class="btn btn-success submit" name="submit" id="submit" />
			</div><br/>
		</div>
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
<s:include value="/view/partailview/footer.jsp"/>
<script type="text/javascript">


(function($,W,D)
{
    var JQUERY4U = {};

    JQUERY4U.UTIL =
    {
        setupFormValidation: function()
        {
            //form validation rules
            $("#loginfrm").validate({
                rules: {				
                	placeid: {
						required:true
					},
					status: {
                        required: true
                    }
                },
				
                messages: {
                	placeid: "Please enter a valid id",
                	status: {
                        required: "Please provide a status"
                    }
                  
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