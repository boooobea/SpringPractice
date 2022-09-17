<%@ page language="java" contentType="text/html; charset=UTF-8"

    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>list</title>
    <style>
        *{
            margin: 0 auto;
            padding: 0px;
        }
        #wrapper{
            width: 1000px;
        }
        h1{
            margin: 20px;
        }
        caption{
            margin: 15px;
            font-size: 25px;
            font-weight: bold;
        }
        table{
            width: 100%;
            text-align: center;
            border-collapse: collapse;
        }
        tr{
            height: 50px;
        }
        td:nth-child(2){
            width: 45%;
        }
        td:nth-child(4), td:nth-child(5){
            width: 15%;
        }
        tr:hover{
            background-color: rgb(202, 247, 232)
        }
        td:nth-child(2):hover{
            font-weight: bold;
        }
        td a{
            text-decoration: none;
            color: black;
        }
        #regBtn{
            width: 120px;
            height: 40px;
            background-color: rgb(239, 204, 139);
            border: solid orange 3px;
            font-size: 17px;
        }
        #regBtn:hover{
            cursor: pointer;
            font-weight: bold;
            font-size: 18px;
        }
        .pagination_wrap{
            width: 100%;
            margin: 0 auto;
        }
        .pagination{
            float: right;
        }
        .pagination li{
            list-style: none;
            margin: 20px;
            float: left;
            font-weight: bold;
            padding: 7px;
        }
        .pagination li a{
            color: black;
            text-decoration: none;
        }
        .pagination li a:hover{
            color: red;
            text-decoration: underline;
        }
        .page{
            background-color: rgb(239, 204, 139);
        }
        /* search */
        .search_area{
            display: flex;
            margin-top: 20px;
        }
        .search_area select{
            margin : 0 10px 0 200px;
        }
        .search_area input{
            width: 450px;
            height: 30px;
            margin: 0px;
        }
        .search_area button{
            margin: 0 0 0 10px;
            width: 60px;
            font-size: 17px;
            background-color: white;
            border: 1px solid rgb(79, 79, 79);
        }
        .search_area button:hover{
            cursor: pointer;
            font-weight: bold;
            background-color: blanchedalmond;
        }

    </style>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" referrerpolicy="no-referrer"></script>
   <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js" integrity="sha512-QDsjSX1mStBIAnNXx31dyvw4wVdHjonOwrkaIhpiIlzqGUCdsI62MwQtHpJF+Npy2SmSlGSROoNWQCOFpqbsOg==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>

   <script>
       $(function(){

            let pervStepResult = "${BOARD_RESULT}";
            if(pervStepResult != null && pervStepResult.length>0){
                alert(pervStepResult);
            }//게시글 알림 

            $('#regBtn').on('click',()=>{
                self.location="/board/register";
            })//게시글 등록

            let moveForm = $('#moveForm');
            $('.move').on("click",function(e){
                e.preventDefault();
                moveForm.append("<input type='hidden' name='bno' value='"+$(this).attr("href")+"'>");
                moveForm.attr("action","/board/get");
                moveForm.submit();
            })//게시글 조회

            $('.pagination a').on('click', function(e){
                e.preventDefault();
                moveForm.find("input[name=currPage]").val( $(this).attr("href"));
                moveForm.attr("action","/board/list");
                moveForm.submit();
            })//페이지 이동

            $('.search_area button').on('click', function(e){
                e.preventDefault();

                let type = $('.search_area select').val();
                let keyword = $('.search_area input[name="keyword"]').val();

                if(!type){
                    alert("검색 종류를 선택하세요.");
                    return false;
                }
                if(!keyword){
                    alert("키워드를 입력하세요.");
                    return false;
                }

                moveForm.find('input[name="type"]').val(type);
                moveForm.find('input[name="keyword"]').val(keyword);
                moveForm.find('input[name="currPage"]').val(1);
                moveForm.submit();
            })//검색 버튼
       });//jq
   </script>

</head>
<body>
    
    <h1>TEST_BOARD / 게시판 목록</h1>
    <hr>
    
    <p>&nbsp;</p>

    <div id="wrapper">
        
        <table border="1">
            <caption> FREE BOARD </caption>
            <button type="button" id="regBtn">게시글등록</button>
            <thead>

                <tr>
                    <th>번 호</th>
                    <th>제 목</th>
                    <th>작성자</th>
                    <th>작성일</th>
                    <th>수정일</th>
                </tr>
            </thead>

            <tbody> 
                <c:forEach var="board" items="${BOARD_LIST}">
                    <tr>
                        <td>${board.bno}</td>
                        <!-- &keyword=${PAGINATION.cri.keyword}&type=${PAGINATION.cri.type} -->
                        <td><a class="move" href="${board.bno}">${board.title}</a></td>
                        <td>${board.writer}</td>
                        <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${board.insertTs}"/> </td>
                        <td><fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${board.updateTs}"/> </td>
               		</tr>
                </c:forEach>
            </tbody>
        </table>

        <div class="search_wrap">
            <div class="search_area">
                <select name="type">
                    <option value="" value="${PAGINATION.cri.type==null?'selected':''}"> - -</option>
                    <option value="T" value="${PAGINATION.cri.type eq 'T'?'selected':''}"> 제목</option>
                    <option value="C" value="${PAGINATION.cri.type eq 'C'?'selected':''}"> 내용</option>
                    <option value="W" value="${PAGINATION.cri.type eq 'W'?'selected':''}"> 작성자</option>
                </select>
                <input type="text" name="keyword" value="${PAGINATION.cri.keyword}">
                <button>검&nbsp;&nbsp;색</button>
            </div>
        </div>

        <div class="pagination_wrap">
            <ul class="pagination">
                <c:if test="${PAGINATION.prev}">
                    <li class="page_prev"><a href="${PAGINATION.startPage-1}">Prev</a></li>
                </c:if>

                <c:forEach var="page" begin="${PAGINATION.startPage}" end="${PAGINATION.endPage}">
                    <li class="page_info ${PAGINATION.cri.currPage==page ? 'page' :''}"><a href="${page}">${page}</a></li>
                </c:forEach>
                
                <c:if test="${PAGINATION.next}">
                    <li class="page_next"><a href="${PAGINATION.endPage+1}">Next</a></li>
                </c:if>
            </ul>
        </div>

        <form id="moveForm" method="get">
            <input type="hidden" name="currPage" value="${PAGINATION.cri.currPage}">
            <input type="hidden" name="amount" value="${PAGINATION.cri.amount}">
            <input type="hidden" name="type" value="${PAGINATION.cri.type}">
            <input type="hidden" name="keyword" value="${PAGINATION.cri.keyword}">
        </form>



        <p>&nbsp;</p>
    </div>
</body>
</html>