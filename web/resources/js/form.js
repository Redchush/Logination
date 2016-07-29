$(document).ready(function() {
 
    var $submit_btn = $(this).find(".submit_btn");
    $submit_btn.addClass("disabled");

   var $email_field =  $("input[type=email]");
   var $pas_field =  $("input[type=password]"); 
   var $login_field =  $("input[type=text]"); 

   $email_field.on("change", checkEmail);

   function checkEmail() {
   	    var _$this = $(this); 
   		var $email = _$this.val();    
        var isValid = isEmailValid($email); 
        processValidResult(isValid, _$this); 
    };

    function isEmailValid(email){
  		var emailReg = /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/;
  		var isValid = emailReg.test(email);
  		return isValid; 
    };

    $pas_field.on("change", checkPassword);

    function checkPassword() {
		var password = $(this).val();
		var isValid = isPasswordValid(password); 
	    return processValidResult(isValid, $(this)); 
	}; 

	function isPasswordValid(password){
		return password.length > 5; 
	}; 

    function processValidResult(isValid, _$this){
    	var errorField = _$this.nextAll(".s-error");
		if (!isValid) {
            errorField.css("visibility", "visible");
            _$this.addClass("wrong");
            $("tips").show();        
        } else {
            _$this.removeClass("wrong");
            errorField.css("visibility", "hidden");
        }
        return isValid; 
    }; 

    $('form').on("submit", function(event) {
    	console.log("here");
    //	event.stopPropagation();
    	var isValid = true;
    	// console.log($(this).call(checkEmail()));

    	$email_field.each(function(){
    	 	var is = isEmailValid( $(this).val().toString());
    		if (!is) {
    		 	isValid = false; 
    		};
    	}); 
    	$pas_field.each(function(){
    		var is = isPasswordValid($(this).val().toString()); 
    		if (!is) {
    		 	isValid = false; 
    		};
    	}); 
       	if (!isValid) {
    		console.log("novalidate");
    		$(".msg_box").show();
    		return false;
    	};   
   	});


    $('form').on("change", checkForm);
	$('form').on("keyup", checkForm);

    function checkForm(){
    	var $btn = $(this).find(".submit_btn");
 		var isAll = true;

        $(this).find("input").each(function() {
            var len = $(this).val().toString();
            if (len < 1) {
                isAll = false;
            };
            if ($(this).hasClass("wrong")) {
            	isAll = false;
            };       
        });

        if (isAll) {
            $btn.removeClass("disabled");
            $btn.attr("disabled", false);
        } else {
            $btn.addClass("disabled").attr("disabled", true);
        };
    }
});


    // dd@llk.lk

    // function validateEmail($email) {
    //   	alert("in");
    //       var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
    //       return emailReg.test($email);
    //   };
    // 		$("input[type=email]").nextAll(".s-error")
    // 					  .css("visibility", "visible");
    // $("input[type=email]").addClass("wrong");


    // 	   var m_action = $(this)[0].action
    // //	  	alert($(this)[0].action);
    // 	var m_data = $(this).serialize();
    //        // var m_method=form.attr('method');
    //        // var m_action=form.attr('action');

    // 	  	jQuery.ajax({
    //                    type: "get",
    //                    url: m_action,
    //                    data: m_data + $(this)[0].name,
    //        });

