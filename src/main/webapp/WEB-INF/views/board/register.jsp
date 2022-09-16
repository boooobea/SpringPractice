<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>board/register.jsp</title>
    <style>
        *{
            margin: 0 auto;
            padding: 0px;
        }
        h1{
            margin: 20px;
        }
        #wrapper{
            width: 800px;
        }
        .input_wrap{
            padding: 5px 20px;
        }
        .input_wrap:nth-child(4){
            text-align: center;
        }
        label{
            display: block;
            margin: 10px 0;
            font-size: 17px;	
        }
        input{
            padding: 5px;
            font-size: 17px;
        }
        textarea{
            width: 600px;
            height: 150px;
            font-size: 15px;
            padding: 10px;
        }
        .btn{
            display: inline-block;
            font-size: 20px;
            background-color:  rgb(239, 204, 139);
            border: solid orange 3px;
            font-weight: bold;
            width: 140px;
            line-height: 39px;
            margin-left : 30px;
            cursor : pointer;
            margin-top: 30px;
        }

    </style>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js" integrity="sha512-QDsjSX1mStBIAnNXx31dyvw4wVdHjonOwrkaIhpiIlzqGUCdsI62MwQtHpJF+Npy2SmSlGSROoNWQCOFpqbsOg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    
       <script>
           $(function(){
                $('#list_btn').on('click',function(){
                    document.location="/board/list"
                });//list_btn

           });//jq
       </script>
</head>
<body>
    
    <h1>TEST_BOARD / 게시글 등록</h1>
    <hr>
  
    <div id="wrapper">

        <form action="/board/register" method="post">
            <div class="input_wrap">
                <label for="title">제 목</label>
                <input type="text" name="title" id="title" size="50"> 
            </div>

            <div class="input_wrap">
                <label for="content">내 용</label>
                <textarea name="content" id="content" cols="52" rows="10"></textarea>
            </div>

            <div class="input_wrap">
                <label for="writer">작성자</label>
                <input type="text" name="writer" id="writer" size="15"> 
            </div>

            <div class="input_wrap">
                <button class="btn" id="list_btn" type="button">목록페이지</button>
                <button class="btn">등록</button>
            </div>
        </form>
    </div>
</body>
</html>