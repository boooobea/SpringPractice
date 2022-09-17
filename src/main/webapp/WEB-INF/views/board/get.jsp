<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html lang="ko">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>board/get.jsp</title>
        <style>
            * {
                margin: 0 auto;
                padding: 0px;
            }
            #wrapper{
                width: 800px;
                margin: 20px 100px;
                padding-left: 20px;
            }
            h1{
                 margin: 20px;
            }
            .input_wrap{
                padding: 5px 20px;
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
                font-size: 22px;
                padding: 6px 12px;
                background-color:  rgb(239, 204, 139);
                border: solid orange 3px;
                font-weight: 600;
                width: 140px;
                height: 41px;
                line-height: 39px;
                text-align : center;
                margin-left : 30px;
                cursor : pointer;
            }
            .btn_wrap{
                padding-left : 80px;
                margin-top : 50px;
            }

        </style>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"
            referrerpolicy="no-referrer"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"
            integrity="sha512-QDsjSX1mStBIAnNXx31dyvw4wVdHjonOwrkaIhpiIlzqGUCdsI62MwQtHpJF+Npy2SmSlGSROoNWQCOFpqbsOg=="
            crossorigin="anonymous" referrerpolicy="no-referrer"></script>
            <!-- reply js -->
        <script src="/resources/js/reply.js"></script>

        <script>
            $(function(){

                let form = $('#boardForm');
                $('#list_btn').on('click', function(e){
                    form.attr("action","/board/list");
                    form.submit();
                })
                $('#modify_btn').on("click",function(e){
                    form.attr("action","/board/modify");
                    form.submit();
                })
            });
        </script>
    </head>

    <body>

        <h1>TEST_BOARD / 게시글 조회</h1>
        <hr>

        <div id="wrapper">

            <div class="input_warp">
                <label>게시글 번호</label>
                <input name="bno" readonly value="${BOARD.bno}">
            </div>

            <div class="input_warp">
                <label>게시글 제목</label>
                <input name="title" readonly value="${BOARD.title}">
            </div>

            <div class="input_warp">
                <label>게시글 내용</label>
                <textarea name="content" readonly value="${BOARD.content}">${BOARD.content}</textarea>
            </div>

            <div class="input_warp">
                <label>게시글 작성자</label>
                <input name="writer" readonly value="${BOARD.writer}">
            </div>

            <div class="input_warp">
                <label>게시글 등록일</label>
                <input name="insertTs" readonly value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${BOARD.insertTs}"/>'>
            </div>

            <div class="input_warp">
                <label>게시글 수정일</label>
                <input name="updateTs" readonly value='<fmt:formatDate pattern="yyyy/MM/dd HH:mm" value="${BOARD.updateTs}"/>'>
            </div>

            <div class="btn_wrap">
                <a class="btn" id="list_btn">목록페이지</a>
                <a class="btn" id="modify_btn">수정 하기</a>
            </div>

            <form id="boardForm" action="/board/modify" method="get">
                <input type="hidden" id="bno" name="bno" value="${BOARD.bno}">
                <input type="hidden" name="currPage" value="${cri.currPage}">
                <input type="hidden" name="amount" value="${cri.amount}">
                <input type="hidden" name="type" value="${cri.type}">
                <input type="hidden" name="keyword" value="${cri.keyword}">

            </form>

            <!-- <div class="content_botton">
                <div class="reply_subject">
                    <h2>댓글</h2>
                </div>
                <div class="reply_button_wrap">
                    <button>댓글쓰기</button>
                </div>
            </div> -->
        </div>
    </body>

    </html>