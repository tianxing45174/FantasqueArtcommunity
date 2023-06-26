function previewFile() {
    var preview = document.querySelector('#hp-user');
    var file    = document.querySelector('#profile_photo').files[0];
    
    var reader = new FileReader();

    reader.onloadend = function () {
        $("#hp-user").replaceWith("<div class=\"hp-user\" id=\"hp-user\" style= \"background-image: url("+reader.result+");\"></div>");
    }

    if (file) {
        reader.readAsDataURL(file);
      } else {
        console.log("0");
        $(".up-submit").prop("disabled","disabled");
        $(".up-submit").addClass("up-submit-false");
        // $(".up-submit").removeClass("up-submit");
        return false;
      }
}