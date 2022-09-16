<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>board/modify.jsp</title>
    <style>
        *{
            margin: 0 auto;
            padding: 0px;
        }
        #wrapper{
            width: 1024px;
            font-family: 'D2Coding';
            font-size: 14px;
            margin-top: 30px;
        }
        #submitBtn,#removeBtn, #listBtn{
            width: 80px;
            height: 40px;
            border: none;
            font-size: 16px;
            font-weight: bold;
            box-shadow: 3px 3px 10px darkgray;
        }
        #submitBtn{
            color: white;
            background-color: green;
        }
        #listBtn{
            color: white;
            background-color: blue;
        }
        #removeBtn{
            color: white;
            background-color: red;
        }
        button:hover{
            cursor: pointer;
        }
    </style>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
       <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js" integrity="sha512-QDsjSX1mStBIAnNXx31dyvw4wVdHjonOwrkaIhpiIlzqGUCdsI62MwQtHpJF+Npy2SmSlGSROoNWQCOFpqbsOg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    
       <script>
           $(function(){
                //삭제버튼 클릭시 post 요청 처리/board/remove?bno=xxx 
                $('#removeBtn').on('click',()=>{
                    let formObj = $('form');
                    // formObj.attr(속성이름, 속성값);
                    // formObj.submit()=>요청 전송
                    formObj.attr('action','/board/remove?bno=${BOARD.bno}&currPage=${param.currPage}&keyword=${param.keyword}&type=${param.type}');
                    formObj.attr('method','POST');
                    formObj.submit();
                })//onClick
                // self : window 객체 

                $('#listBtn').on('click',()=>{
                    self.location="/board/list?currPage=${param.currPage}&keyword=${param.keyword}&type=${param.type}";
                })//onClick
           });//jq
       </script>
</head>
<body>
    
    <h1>WEB-INF/view/board/modify.jsp</h1>
    <hr>
  
    <div id="wrapper">

        <form action="/board/modify?currPage=${param.currPage}&keyword=${param.keyword}&type=${param.type}" method="post">
            <table>
                <tbody>
                    <tr><!-- bno -->
                        <td><label for="bno">글번호</label></td>
                        <td><input type="text" name="bno" id="bno" readonly size="10"  value="${BOARD.bno}" readonly> </td>
                    </tr>
                    <tr><!-- title -->
                        <td><label for="title">제목</label></td>
                        <td><input type="text" name="title" id="title" size="50" value="${BOARD.title}"> </td>
                    </tr>
                    <tr><!-- content -->
                        <td><label for="content">내용</label></td>
                        <td><textarea name="content" id="content" cols="52" rows="10">${BOARD.content}</textarea></td>
                    </tr>
                    <tr><!-- title -->
                        <td><label for="writer">작성자</label></td>
                        <td><input type="text" name="writer" id="writer" readonly size="15" value="${BOARD.writer}"> </td>
                    </tr>
                    <tr>
                        <td colspan="2"> &nbsp;</td>
                    </tr>
                    <tr> <!-- button 3 -->
                        <td colspan="2">
                            <button type="submit" id="submitBtn">SUBMIT</button>
                            <button type="button" id="removeBtn">REMOVE</button>
                            <button type="button" id="listBtn">LIST</button>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form>
    </div>
</body>
</html>