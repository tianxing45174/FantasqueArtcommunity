$(function(){
    function count(){
        var title_count = $("#title").val().length;
        var cm_count = $("#comment").val().length;
        var titletwo = $("#titletwo");

        $(".title-count").text(title_count);
        $(".cm-count").text(cm_count);

        titletwo.attr({value:" " + $("#title").val() + " "})

        var file = document.querySelector('#input-file').files[0];
        var reader = new FileReader();
        if (file) {
            if( title_count > 20 || cm_count > 300 || title_count < 1){
              console.log("不通过");
              $(".up-submit").prop("disabled","disabled");
              $(".up-submit").addClass("up-submit-false");
              // $(".up-submit").removeClass("up-submit");
              return false;
          } else {
              console.log("通过");
              $(".up-submit").removeAttr("disabled");
              // $(".up-submit").addClass("up-submit");
              $(".up-submit").removeClass("up-submit-false");
              return true;
          }
        } else {
          console.log("不通过");
          $(".up-submit").prop("disabled","disabled");
          $(".up-submit").addClass("up-submit-false");
          // $(".up-submit").removeClass("up-submit");
          return false;
        }

    }
    $(".ttext").keyup(function(){
        count();
    })

})

function previewFile() {
    var preview = document.querySelector('#photo-show');
    var file    = document.querySelector('#input-file').files[0];

    var reader  = new FileReader();

    reader.onloadend = function () {
        $("#photo-show").replaceWith("<div id=\"photo-show\" style= \"background-image: url("+reader.result+");\"></div>");

        var title_count = $("#title").val().length;
        var cm_count = $("#comment").val().length;

        if( title_count > 20 || cm_count > 200 || title_count < 1){
          console.log("不通过");
          $(".up-submit").prop("disabled","disabled");
          $(".up-submit").addClass("up-submit-false");
          // $(".up-submit").removeClass("up-submit");
          return false;
      } else {
          console.log("通过");
          $(".up-submit").removeAttr("disabled");
          // $(".up-submit").addClass("up-submit");
          $(".up-submit").removeClass("up-submit-false");
          return true;
      }
    }

    if (file) {
      reader.readAsDataURL(file);
    } else {
      console.log("不通过");
      $(".up-submit").prop("disabled","disabled");
      $(".up-submit").addClass("up-submit-false");
      // $(".up-submit").removeClass("up-submit");
      return false;
    }
    
  }