//회원가입 버튼
$(document).ready(function () {
  $(".join_button").click(function () {
    $("#join_form").attr("action", "/member/join");
    $("#join_form").submit();
    console.log("찍히냐");
  });
});

