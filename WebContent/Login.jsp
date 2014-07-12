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


<div class="span6">
<div class="box">
<h4 class="notice-title">Existing Member</h4>
<div class="notice">
<div class="alert alert-danger" id="result1" style="display:none"><span id="result"></span></div>
<form name="loginfrm" class="form-horizontal" id="loginfrm" enctype="" action="checkLogin.action" method="post">
		<div class="control-group">
			<label class="control-label" for="userEmail">Email<span style="color: #c30">*</span></label>
			<div class="controls">
			  <input type="email" name="userEmail" id="userEmail" class="span3 validate['required','email']" value="" title="Email address"/>
			  <input name="action" id="action" value="login" type="hidden"/>
			</div>
		</div>
	  
	   <div class="control-group">
			<label class="control-label" for="userPassword">Password<span style="color: #c30">*</span></label>
			<div class="controls">
			  <input type="password" name="userPassword" id="userPassword" class="span3 validate['required']" title="Password"/>
			</div>
		</div>

		<div class="control-group">
			<div class="controls">
			 <input type="submit" value="Login" class="btn btn-success submit" name="submit" id="submit" /> <a href="#" class="forgot-password">Forgot your password?</a>
			<br/>
			</div><br/>
		</div>
	</form>
</div>
</div>


</div>
<div class="span6">
	
<div class="box">
<h4 class="notice-title">Registration for New Member</h4>
<div class="notice">

<form class="form-horizontal" id="registrationForm" action="saveNewUser.action" method="post">
	   <div class="control-group">
		<label class="control-label required" for="regName">Name</label>
		<div class="controls">
		  <input type="text" name="regName" id="regName" placeholder="Name" class="validate['required']"/>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regUserPhone">Phone</label>
		<div class="controls">
		  <input type="text" name="regUserPhone" id="regUserPhone" placeholder="Phone" class="validate['required']"/>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regInputAddress">Address</label>
		<div class="controls">
		  <textarea name="regInputAddress" id="regInputAddress" class="validate['required']"> </textarea>
		</div>
	  </div>
	   <div class="control-group">
		<label class="control-label required" for="regInputPostcode">Postcode</label>
		<div class="controls">
		  <input type="text" name="regInputPostcode" id="regInputPostcode" placeholder="Postcode" value="">	  
		<span id="postcodestatus"></span>	
		</div>
	  </div>
	   <div class="control-group">
		<label class="control-label required" for="regInputCity">City</label>
		<div class="controls">
		  <input type="text" name="regInputCity" id="regInputCity" placeholder="City" class="validate['required']"/>
		</div>
	  </div>


	  <div class="control-group">
		<label class="control-label required" for="regInputEmail">Email</label>
		<div class="controls">
		  <input type="text" name="regInputEmail" id="regInputEmail" placeholder="Email" class="validate['required','email']"/>
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regInputPassword">Password</label>
		<div class="controls">
		  <input type="password" name="regInputPassword" id="regInputPassword" placeholder="Password" class="validate['required']"/>
		  <input type="hidden" name="reg" value="1">
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regInputConfirmPassword">Confirm Password</label>
		<div class="controls">
		  <input type="password" name="regInputConfirmPassword" id="regInputConfirmPassword" placeholder="Confirm Password" class="validate['required']"/>
		  <input type="hidden" name="reg" value="1">
		</div>
	  </div>
	  <div class="control-group">
		<label class="control-label required" for="regInputCaptcha"><img src=" <s:url action='getCaptcha?imageId=captcha.png' />" /></label>
		<div class="controls">
		  <input type="text" name="regInputCaptcha" id="regInputCaptcha" placeholder="Enter the text here" class="validate['required']"/>
		</div>
	  </div>	  
	  <div class="control-group">
		<div class="controls">
				  <button type="submit" class="btn btn-success">Register</button>
				  <button onclick="ajaxcall()">ajaxcall</button>
		</div>
	  </div>
	  <div class="" style="text-align:center;">Your email id will be used as username.</div>
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

    JQUERY4U.UTIL =
    {
        setupFormValidation: function()
        {
            //form validation rules
            $("#loginfrm").validate({
                rules: {				
                	userEmail: {
						required:true,
						email:true
					},
					userPassword: {
                        required: true,
                        minlength: 5
                    }
                },
				
                messages: {
                    username: "Please enter a valid email address",
                    password: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },
                  
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });
            
            jQuery.validator.addMethod("checkEmail", function(value, element) {
            	  
            	var emailIdEntered=$("#regInputEmail").val();
            	var existingemail;
            	$.ajax({url:'ajaxAction.action',
            			type:'POST',
            			async:false, 
            			data:{emailIdToCheck : emailIdEntered}, 
            			success:function(jsonResponse) {                			
            				 
            				if(jsonResponse=="true")
            					existingemail=true;
            				else
            					existingemail=false
             				}
            		});
            	
            	return existingemail;
            }, "This email id is already in use.");
			
            
            
            jQuery.validator.addMethod("allowOnlyNumbers", function(value, element) {
          	  
            	return /[0-9\.]/.test(value);
            }, "This field can contain only number(s).");
		
            $("#registrationForm").validate({
                rules: {	
					regName:{required:true},
					regUserPhone:{
						required:true,
						minlength: 10,
						allowOnlyNumbers:true
					},
					regInputAddress:{required:true},
					regInputPostcode:{required:true},
					regInputCity:{required:true},
					regInputEmail:{
						required:true,
						email:true,
						checkEmail:true
					},
					regInputPassword:{
						required: true,
                        minlength: 6
					},
					regInputConfirmPassword:{
					required:true,
					equalTo:'#regInputPassword'
					}
                },
				
                messages: {
                    
					regName: "Please provide a name.",
					regUserPhone: {
						required:"Please provide a phone.",
						minlength:"Minimum of 10 digits."
					},
					regInputAddress: "Please provide a address.",
					regInputPostcode: "Please provide a postcal code.",
					regInputCity: "Please provide a city.",
					regInputEmail:{
						required: "Please provide a email.",
						email: "Please provide valid email."
			
					},
					regInputPassword:{
						required: "Please provide a password.",
                        minlength: "Minimum length of password is 6."
					},
					regInputConfirmPassword:{
						required: "Please provide a password.",
						equalTo: "Please enter text same as password."
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
  