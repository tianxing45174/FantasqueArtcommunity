$(function () {
    function login_test() {
        var username = $("#username").val();
        var password = $("#password").val();
        if (username.length < 1 || password.length < 1) {
            // console.log("0");
            $("#login").prop("disabled", "disabled");
            $("#login").addClass("signup-btn");
            $("#login").removeClass("signup-btn-true");
            return false;
        } else {
            // console.log("1");
            $("#login").removeAttr("disabled");
            $("#login").addClass("signup-btn-true");
            $("#login").removeClass("signup-btn");
            return true;
        }
    }
    $("#username").keyup(function () {
        login_test();
    })
    $("#password").keyup(function () {
        login_test();
    })
})
function ac_check() {

    $(".ac-alert").animate({ opacity: 'show' }, 500, function () {
        $(".ac-alert").hide(1000)
    });
    return false;
}

function _login() {
    $.ajax({
        type: "POST",
        url: "/user/login",
        data: JSON.stringify({
            username: $("#username").val(),
            password: $("#password").val()
        }),
        contentType: "application/json",
        success: function (res) {
            // 处理响应
        },
    });

}