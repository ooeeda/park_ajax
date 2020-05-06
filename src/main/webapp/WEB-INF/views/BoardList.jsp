<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<head>
	<title>BoardList</title>
	<link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css">
	<script type="text/javascript" src="/resources/lib/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
		
	
		var selectBoardList = function(page) { 
			$.ajax({
				url: '/selectBoardList',
				data: {page: page},
				success: function(resData, textStatus, jqXHR ) {
					console.log(resData);
					
					var list = resData.boardlist.list;
					var template = '';
					

					
					$.each(list, function(idx, obj) { 
						template += '<tr>' +
		                '    <td>' + obj.seq + '</td>' +
		                '    <td><a href="BoardRead?seq=' + obj.seq + '">' + obj.subject + '</a></td>' +               
		                '    <td>' + obj.name + '</td>' +
		                '</tr>';
					});
					
					var page = resData.boardlist.page;
					var pageplate = '';
					
					pageplate += '<li><a href="#" data-page="1"><<</a></li>';
					pageplate += '<li><a href="#" data-page="'+ page.prevPage +'"><</a></li>';
					for(var i=page.startBlockPage; i<page.endBlockPage; i++){
						
						if(i == page.nowPage){
							pageplate += '<li class="page-item active"><a href="#" data-page="'+i+'">'+i+'<span class="sr-only">(current)</span></a></li>';
						}else{
							pageplate += '<li><a href="#" data-page="'+ i +'">'+ i +'</a></li>';
						}						
					}
					
					pageplate += '<li><a href="#" data-page="'+ page.nextPage +'">></a></li>';
					pageplate += '<li><a href="#" data-page="'+ page.lastPage +'">>></a></li>';
					
					
					
					$('tbody').html(template);
				
					$('ui').html(pageplate);
					
					$('ui a').click(function() {
						selectBoardList($(this).data('page'));
					});
				}
			});
		}
	
		$(document).ready(function() {
			selectBoardList(1);
		});
	</script>
</head>
<body>
    <h1>게시판 리스트</h1>
    <a href="#" data-page="2"></a>
    <table class="table table-stripted">
        <thead>
            <tr>
                <th>순번</th>
                <th>제목</th>
               
                <th>이름</th>
            </tr>
        </thead>
        <tbody>
        	<%-- 
            <c:forEach items="${boardlist.list}" var="list">
                <tr>
                    <td>${list.seq}</td>
                    <td><a href="BoardRead?seq=${list.seq}">${list.subject}</a></td>                
                    <td>${list.name}</td>
                </tr>
            </c:forEach>
             --%>
        </tbody>
     
    </table>
 <a class="btn btn-default" href="boardWrite?seq=0">글쓰기</a>
 <div class="text-center">
 <%-- 
 <ui class="pagination">
 	${boardlist.page.page}
 </ui>
  --%>
  <ui class="pagination">
  </ui>
  
</div>

</body>
</html>

