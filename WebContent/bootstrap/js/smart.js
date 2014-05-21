/* 
: Contact
=============================
-----------------------------
	Adhikari Surya
	Email: adh.surya@gmail.com
	www.bootstrappage.com
-----------------------------
=============================
 */
pic1 = new Image(16, 16); 
pic1.src = "loader.gif";
$(document).ready(function() {
	$('.p1').mouseenter(function() {
	$('.p1').popover('show');
	});
	$('.p1').mouseout(function() {
	$('.p1').popover('hide');
	});

/* Home page item price animation---------------------------------------------*/
$('#featuredProduct .well').mouseenter(function() {
 // $(this).children('.price').fadeOut();
  $(this).children('.itemInfoSlide').fadeIn();
  $(this).children('.itemInfoSlide').animate({
	opacity:'0.95',
	top:'0',
  }, 200, function() {
    // Animation complete.
	
  });
});

$('#featuredProduct .well').mouseleave(function() {
	//$(this).children('.price').fadeIn();
	//$(this).animate({
	$(this).children('.itemInfoSlide').animate({
	opacity:'0',
    top: '0'
  }, 600, function() {
    // Animation complete.
	//$(this).children('.overlay').fadeOut(50)
  });
});
	
	
/* main page and product page carousel animation---------------------------------------------*/
/* carousel---------------- */
	$('#myCarousel').carousel({
	  interval: 3000
	})
	
	$('#myModalalert').delay(3000).modal('show').delay(3000);
	//$('#myModal').modal('hide').delay(8000)

$("#selectorId").change(function() { 
var usr = $("#selectorId").val();
if(usr.length >= 4)
{
$("#status").html('<img src="loader.gif" align="absmiddle">&nbsp;Checking...');
    $.ajax({  
    type: "POST",  
    url: "check.php",  
    data: "dTime="+ usr,  
    success: function(msg){  
   
   $("#status").ajaxComplete(function(event, request, settings){ 

	if(msg == 'OK')
	{ 
        $("#username").removeClass('object_error'); // if necessary
		$("#username").addClass("object_ok");
		$(this).html('&nbsp;<img src="tick.gif" align="absmiddle">');
		$("#deliveryAt").html(usr);
	}  
	else  
	{  
		$("#username").removeClass('object_ok'); // if necessary
		$("#username").addClass("object_error");
		$(this).html(msg);
	}  
   
   });
 } 
  }); 

}

else
	{
	$("#status").html('<font color="red">The username should have at least <strong>4</strong> characters.</font>');
	$("#username").removeClass('object_ok'); // if necessary
	$("#username").addClass("object_error");
	}

});


/* Email validate------------------------------------------------------------------------- */
$("#reginputEmail").change(function() { 
var mail = $("#reginputEmail").val();
$("#emailstatus").html('<img src="loader.gif" align="absmiddle">&nbsp;Checking email...');
    $.ajax({  
    type: "POST",  
    url: "validation.php",  
	data: "userEmail="+ mail,  
    success: function(msg){  
   $("#emailstatus").ajaxComplete(function(event, request, settings){ 

	if(msg == 1)
	{ 
        $("#reginputEmail").parent(".controls").parent(".control-group").removeClass('error'); // if necessary
		$("#emailstatus").html('&nbsp;<img src="tick.gif" align="absmiddle">');
		
	}  
	else  
	{  
		$("#reginputEmail").parent(".controls").parent(".control-group").addClass("error");
		$("#emailstatus").html('&nbsp;<img src="cross.png" align="absmiddle">');
	}  
   });
 }  
  }); 
});


/* Postcode validate------------------------------------------------------------------------- */
$("#reginputPostcode").change(function() { 
var postcode = $("#reginputPostcode").val();
$("#postcodestatus").html('<img src="loader.gif" align="absmiddle">&nbsp;Checking Postcode...');
    $.ajax({  
    type: "post",  
    url: "validationpostcode.php",  
	data: "userPostcode="+ postcode,  
    success: function(msgpc){  
   $("#postcodestatus").ajaxComplete(function(event, request, settings){ 

	if(msgpc == "OK")
	{ 
        //$("#reginputPostcode").removeClass('error'); // if necessary
		$("#reginputPostcode").parent(".controls").parent(".control-group").removeClass('error');
		$('#postcodestatus').html('&nbsp;<img src="tick.gif" align="middle">');
		$("#reginputPostcode").val(postcode);
		//alert("Valid postcode ");
	}  
	else  
	{  
		if(msgpc == "NOTOK"){
			$("#reginputPostcode").parent(".controls").parent(".control-group").addClass("error");
			$('#postcodestatus').html('&nbsp;<img src="cross.png" align="middle">');
			//alert("Invalid postcode \n OR \n Our services is not available in your area.");
			$("#reginputPostcode").val('');
			//$("#reginputPostcode").focus();
		}
		else
		{

			$("#reginputPostcode").parent(".controls").parent(".control-group").addClass("error");
			$('#postcodestatus').html('&nbsp;<img src="cross.png" align="middle">');
			alert("Invalid postcode \n OR \n Our services is not available in your area.");
		}
	}  
   });
 }  
  }); 
});


/* Special Order Message 
------------------------------------------------------------------------- */
$("#specialMessage").click(function() { 
	$('#specialMessage').val('').empty();
	$("#msgstatus").html('');
});
$("#specialMessage").change(function() { 
	var messages = $("#specialMessage").val();
	$("#msgstatus").html('<img src="loader.gif" align="absmiddle">&nbsp;Checking email...');
		$.ajax({  
		type: "POST",  
		url: "special_messages.php",  
		data: "specialMessage="+ messages,  
		success: function(mesg){  
	   $("#msgstatus").ajaxComplete(function(event, request, settings){ 
	   
		if(mesg == 1)
		{ 
			$(this).html('&nbsp;<img src="tick.gif" align="absmiddle"><span style="color:#008800">&nbsp; Your message has been stored</span><br>');
		}  
		else  
		{  
			$(this).html('<img src="cross.png" align="absmiddle"> <span style="color:red">&nbsp; Message should be less then 10 character</span><br>');
		}  
	   });
	}  
}); 
});
/* ======================== */
/* ======================== */
/* ======================== */
(function($,W,D)
{
    var JQUERY4U = {};

    JQUERY4U.UTIL =
    {
        setupFormValidation: function()
        {
            //form validation rules
            $("#registrationForm").validate({
                rules: {				
					userPhone:{ 
						required:true,
						number:true,
						minlength: 11
					},
					userName:{
						required:true,
						alphabet:true
					},
					
					userAddress: "required",
					postcode: "required",
					city: "required",
					userEmail: {
						required:true,
						email:true
					},
                    password: {
                        required: true,
                        minlength: 5
                    },
                    agree: "required"
                },
				
                messages: {
                    userPhone: "Please enter your valid phone (11 dizit) number",
					userName: "Please enter your full name",
					userAddress: "Please enter your address",
					postcode: "Please enter your postcode",
					city: "Please enter your city",
					
                    password: {
                        required: "Please provide a password",
                        minlength: "Your password must be at least 5 characters long"
                    },
                    userEmail: "Please enter a valid email address",
                    agree: "Please accept our policy"
                },
                submitHandler: function(form) {
                    form.submit();
                }
            });
			
			//form validation rules
            $("#loginfrm").validate({
                rules: {				
					username: {
						required:true,
						email:true
					},
                    password: {
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
        }
    }

    //when the dom has loaded setup form validation rules
    $(D).ready(function($) {
        JQUERY4U.UTIL.setupFormValidation();
    });

})(jQuery, window, document);
	
$('.blink').each(function() {
    var elem = $(this);
    setInterval(function() {
        if (elem.css('visibility') == 'hidden') {
            elem.css('visibility', 'visible');
        } else {
            elem.css('visibility', 'hidden');
        }    
    }, 400);
});

	/* ============================ */

});