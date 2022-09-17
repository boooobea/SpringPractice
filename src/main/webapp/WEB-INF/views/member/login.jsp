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
    <title>Login</title>
    <link rel="stylesheet" href="${path}/resources/css/login.css">
</head>
<body>
    <div class="container">

        <div class="wrap">

            <div class="logo_wrap">
                <span>Book Mall</span>
            </div>

            <div class="login_wrap">

                <div class="id_input_box">
                    <input type="text" name="id" class="id_input" placeholder="아이디">
                </div>
                
                <div class="pw_input_box">
                    <input type="password" name="password" class="pw_input" placeholder="비밀번호">
                </div>
                
                <div class="bt_box">
                    <input type="button" value="로그인" class="login_button">
                </div>

            </div>
        </div>
    </div>
</body>
</html>