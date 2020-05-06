<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.io.*" %>
<%@page import="java.util.*"%>



<html>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css">

<head>
<title>BoardRead</title>
	<script type="text/javascript" src="/resources/lib/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
	
	var selectReadBoard = function(seq){
		$.ajax({
			url:'/selectBoardRead',
			data:{seq:seq},
			success: function(resData, textStatus, jqHXR){
				
				var board = resData.boardRead;
				
				var template = '';
				
				template += '<tr>'+
						'    <td>' +board.seq    +'</td>'+
						'    <td>'+board.subject +'</td>'+
						'    <td>'+board.name    +'</td>'+						
				        '</tr><tr>'+
				        '    <td colspan="3">'+board.memo    +'</td>'+
				        '</tr>';
				
				var file = resData.fileList;
				        
				$.each(file, function(idx, obj){
					template +=	'<tr>'+
					 ' <td colspan="3"> <img src="/upload/'+obj.local_file_name+'"></td>'+
					 '</tr>';
					
				});		
				
				$('tbody').html(template);
				
				$('#updateBtn').attr("href","boardWrite?seq="+board.seq);
				      
			}
		});
 	}
 	
	$(document).ready(function() {
		selectReadBoard('${param.seq}');
	});
	</script>
</head>
<body>
  <h1>게시판 내용</h1>

    <table class="table">
        <thead>
            <tr>
                <th>순번</th>
                <th>제목</th> 
                <th>이름</th>              
            </tr>
        </thead>
        <tbody>

    
        </tbody>
        

     
    </table>
<a id = 'updateBtn' class="btn btn-default" href="">수정</a> 
 
</body>
</html>

