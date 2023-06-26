$(function(){
    function sign_test(){
        var username = $("#username").val();
        var password_one = $("#password-one").val();
        var password_two = $("#password-two").val();
        if(username.length < 1 || password_one.length < 1 || password_two.length < 1){
            console.log("0");
            $("#sign").prop("disabled","disabled");
            $("#sign").addClass("signup-btn");
            $("#sign").removeClass("signup-btn-true");
            return false;
        } else {
            console.log("1");
            $("#sign").removeAttr("disabled");
            $("#sign").addClass("signup-btn-true");
            $("#sign").removeClass("signup-btn");
            return true;
        }
    }
    $("#username").keyup(function(){
        sign_test();
    })
    $("#password-one").keyup(function(){
        sign_test();
    })
    $("#password-two").keyup(function(){
        sign_test();
    })

})

function check(){
    var password_one = $("#password-one").val();
    var password_two = $("#password-two").val();
    
    var username = $("#username").val();
    patt = /^[A-Z][\w]{5,18}$/;
    username.trim(username);
    if ( !patt.test(username) ) {
        $(".ac-c-alert").animate({opacity:'show'},500,function(){
            $(".ac-c-alert").hide(1000)
        });
        return false;
    }

    patt = /^[A-Za-z\d!@#$%^&*]{8,16}$/
    if(password_one == password_two){
        if (!patt.test(password_two)){
            $(".psw-c-alert").animate({opacity:'show'},500,function(){
                $(".psw-c-alert").hide(1000)
            });
            return false
        }
        return true;
    } else {
        console.log("false")
        
        $(".psw-alert").animate({opacity:'show'},500,function(){
            $(".psw-alert").hide(1000)
        });
        return false;
    }
    
}
function ac_check(){

    $(".ac-alert").animate({opacity:'show'},500,function(){
        $(".ac-alert").hide(1000)
    });
    return false;
}
function psw_check(){

    $(".psw-alert").animate({opacity:'show'},500,function(){
        $(".psw-alert").hide(1000)
    });
    return false;
}
function ac_c_check(){
    var username = $("#username").val();
    patt = /^[A-Z][\w]{5,18}$/;
    username.trim(username);
    if ( !patt.test(username) ) {
        $(".ac-c-alert").animate({opacity:'show'},500,function(){
            $(".ac-c-alert").hide(1000)
        });
        return false;
    }
}