<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

    <!DOCTYPE html>
    <html lang="ko">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

         <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
		  
        <title>JOIN</title>
        <link rel="stylesheet" href="${path}/resources/css/join.css">
        
    </head>
    <body>
        <div class="container">
            <div class="wrap">
            
                <form id="join_form" method="post" >
                    <div class="form_wrap">
    
                        <div class="subject">
                            <span>회원가입</span>
                        </div>
    
                        <div class="input_wrap">
                            <div class="name">아이디</div>
                            <div class="id_input_box">
                                <input type="text" name="memberId" class="input_form" id="id_input">
                            </div>
                            <span class="id_input_re_1">사용 가능한 아이디 입니다.</span>
                            <span class="id_input_re_2">아이디가 이미 존재합니다.</span>
                        </div>
                        
                        <div class="input_wrap">
                            <div class="name">비밀번호</div>
                            <div class="pw_input_box">
                                <input type="password" name="memberPw" class="input_form">
                            </div>
                        </div>
    
                        <div class="input_wrap">
                            <div class="name">비밀번호 재확인</div>
                            <div class="pw_input_box">
                                <input type="password" name="pwc" class="input_form">
                            </div>
                        </div>
    
                        <div class="input_wrap">
                            <div class="name">이름</div>
                            <div class="id_input_box">
                                <input type="text" name="memberName" class="input_form">
                            </div>
                        </div>
    
                        <div class="input_wrap">
                            <div class="name">이메일</div>
                            <div class="id_input_box">
                                <input type="text" name="memberEmail" class="input_form" id="mail_input">
                            </div>
                        </div>
                        <div class="mail_check_wrap">

                            <div class="mail_check_input_box" id="mail_check_input_box_false">
                                <input class="mail_check_input" disabled>
                            </div>

                            <div class="mail_check_button">
                                <span>인증번호</span>
                            </div>

                            <div class="clearfix"></div>
                        </div>
    
                        <div class="input_wrap">
                            <div class="name">한줄메모</div>
                            <div class="memo">
                                <input type="text" name="memberMemo" class="input_form">
                            </div>
                        </div>
    
                        <div class="input_wrap">
                            <div class="id_input_box">
                                <input type="button" value="가입하기" class="join_button">
                            </div>
                        </div>
                
                    </div>
                </form>
        </div>
        </div>
       <script>
        $(function(){
            
            //회원가입버튼
            $('.join_button').click(function(){
                $('#join_form').attr("action","/member/join");
                $('#join_form').submit();
            })//JoinButton

            //아이디중복검사
            $("#id_input").on("input", function () {
                var memberId = $('#id_input').val();
                var data ={memberId:memberId}       //컨트롤에 넘기는데이터 
    
                $.ajax({
                    type:"post",
                    url:"/member/memberIdChk",
                    data : data,
                    success : function(result){
                        if(result !='fail'){
                            $('.id_input_re_1').css("display","inline-block");
                            $('.id_input_re_2').css("display","none");
                        } else {
                            $('.id_input_re_1').css("display","none");
                            $('.id_input_re_2').css("display","inline-block");
                        }//if-else 
                        
                    }//success 
                    
                });//ajax 종료
            });//IdCheck

            $('.mail_check_button').click(function(){
                let email = $('#mail_input').val(); //입력한 이메일 값
                
                $.ajax({
                    type : 'get',
                    url : "/member/mailCheck?email="+email,

                })//ajax
            });//EmailCheck

        });//jq

       </script>
    </body>
    </html>