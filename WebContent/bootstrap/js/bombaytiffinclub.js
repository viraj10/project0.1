
 simpleCart({
	// array representing the format and columns of the cart,
	// see the cart columns documentation
	cartColumns: [
		//{ view:"hidden", attr: "id", label: "ID"},		
		//{ view: "image" , attr:"thumb", label: "Image" },	
		{ attr: "name", label: "Name"},
		//{ view: "currency", attr: "price", label: "Price"},
		{ attr: "gradient", label: "Special" },
		//{ attr: "mis", label: "Other" },
		
		{ view: "currency", attr: "total", label: "Price" },
		//{ view:"input", attr: "quantity", label: "Qty"},
		//A custom cart column for putting the quantity and increment and decrement items in one div for easier styling.
			{ view: function(item, column){
				return	"<div class='pull-right'><div class='btn-group'><span class='btn btn-mini'>"+item.get('quantity')+" </span> " + 
							"<a href='javascript:;' class='simpleCart_increment btn btn-mini'> <i class='icon-plus'></i> </a>" +
							"<a href='javascript:;' class='simpleCart_decrement btn btn-mini'> <i class='icon-minus'></i> </a>"+
							"<a href='javascript:;' class='simpleCart_remove btn btn-danger btn-mini'> <i class='icon-remove'></i> </a></div></div>";
			}, attr: 'custom', label:"Edit" }
			
		//{ view: "decrement", label: false},
		//{ view: "increment", label: false},
		//{ view: "currency", attr: "total", label: "SubTotal" },
		//{ view: "remove", text: "Remove", label: false},
		//{ view: function(item, column){
		//	return  "<a href='javascript:;' class='simpleCart_remove'><i class='icon-remove'></i></a>";
		 // } , 
		//  attr: "custom" ,
		//  label: "false"
		//}

		
		
		
		
	],

	// "div" or "table" - builds the cart as a 
	// table or collection of divs
	cartStyle: "table", 

	// how simpleCart should checkout, see the 
	// checkout reference for more info 
	//checkout: { 
	//	type: "PayPal" , 
	//	email: "developer.sba@gmail.com" 
	//},
	

    checkout: { 
        type: "SendForm" , 
        url: "pay.php" ,

        // http method for form, "POST" or "GET", default is "POST"
        method: "POST" , 

        // url to return to on successful checkout, default is null
        success: "success.html" , 

        // url to return to on cancelled checkout, default is null
        cancel: "cancel.html" ,

        // an option list of extra name/value pairs that can
        // be sent along with the checkout data
        extra_data: {
          storename: "Bob's cool plumbing store",
          cartid: "12321321"
        }
    },


	

	// set the currency, see the currency 
	// reference for more info
	currency: "GBP",

	// collection of arbitrary data you may want to store 
	// with the cart, such as customer info
	data: {},

	// set the cart langauge 
	// (may be used for checkout)
	language: "english-us",

	// array of item fields that will not be 
	// sent to checkout
	excludeFromCheckout: [],

	// custom function to add shipping cost
	shippingCustom: null,

	// flat rate shipping option
	shippingFlatRate: 0,

	// added shipping based on this value 
	// multiplied by the cart quantity
	shippingQuantityRate: 0,

	// added shipping based on this value 
	// multiplied by the cart subtotal
	shippingTotalRate: 0,

	// tax rate applied to cart subtotal
	taxRate: 0,

	// true if tax should be applied to shipping
	taxShipping: false,

	// event callbacks 
	beforeAdd			: null,
	afterAdd			: null,
	load				: null,
	beforeSave			: null,
	afterSave			: null,
	update				: null,
	ready				: null,
	checkoutSuccess		: null,
	checkoutFail		: null,
	beforeCheckout		: null,
    beforeRemove        : null
});


/*

for paysafecard-

          simpleCart({
              checkout: {
                  type: "SendForm" ,
                  url: "https://sandbox.payfast.co.za/eng/process" ,
                  // HTTP method for form, "POST"
                  method: "POST" ,
                  // URL to redirect browser to after successful checkout
                  success: "http://yourwebsite.co.za/success.html" ,
                  // URL to redirect browser to after checkout was cancelled by buyer
                  cancel: "http://yourwebsite.co.za/cancel.html" ,
                  extra_data: {
                      currency_code: "ZAR",
                      merchant_id: "10000100",
                      merchant_key: "46f0cd694581a",
                      notify_url: "http://yourwebsite.co.za/notify.html", //this is the ITN or callback URL
                      amount: simpleCart.total, // Total amount = item1 + item2 + item3 etc
                      name_first: "Buyer first name",
                      name_last: "Buyer last name",
                  }
              },
              beforeCheckout: function( data ){
                  data.currency = "ZAR";
                  data.cancel_url = data.cancel_return;
                  data.return_url = data.return;
                  var payfast_description = '';
                  for (var key in data)
                      if (key.match(/^item_name/))
                          payfast_description += ' '+data[key];
                  data.item_description = data.item_name = payfast_description;
              }
          });

		  
		  */