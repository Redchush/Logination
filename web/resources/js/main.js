
$(document).ready(function() {
 

 $("#tabs").children(".sort-btn").on("click", function () {
    $(this).addClass("active");
    var other = $("#tabs").children(".sort-btn").not($(this)).removeClass("active");
    other.children().removeClass("icon_up").addClass("icon_down");
    var isUp = $(this).data("sort") == "up";
    $(this).children().removeClass(".icon_down").addClass("icon_up");
  });


  $(".remove").on("click", function (evt) {
    var tag = $(this).parent().parent().parent();
    $(this).hide();
    $(".possibleTags").find("ul").append(tag);
    evt.stopPropagation();
  });

  $(".possibleTags").find("li").on("click", function () {
    //  var inner = '<span class="remove"><em></em></span>';
    var _$this = $(this);
    var _$removeSign = _$this.find(".remove");
    _$removeSign.show();
    $(".chosenTags").children().append(_$this);
  });


  $(".btn.newAnswer-btn").on("click", function () {
    $(this).addClass("active")
      .addClass("test");
    alert("done!");
  });

}); 



