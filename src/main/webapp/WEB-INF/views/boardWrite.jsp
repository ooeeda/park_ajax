<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="/resources/bootstrap/css/bootstrap.css">


<head>
<title>Home</title>
	<script type="text/javascript" src = "resources/lib/jquery-3.4.1.min.js"></script>
	<script type="text/javascript">
	
	var selectBoardWrite = function(seq){
		$.ajax({
			url:'/selectBoardWrite',
			data:{seq:seq},
			success: function(resData, textStatus, jqHXR){
				
				var board = resData.board;
							
				//$("input[name=subject]").value(board.subject);
				// $("[id='subject']").val(board.subject); 
				//$(".from-control") //클래스 참조
				//$("[class='from-control']") //클래스 참조
				//$("legend").html();
				//$("legend").text();
				
				$("#subject").val(board.subject);
				$("#name").val(board.name);
				
				$("#memo").val(board.memo);
				
				$("#seq").val(board.seq);			
				
				
			}			
			
		});
	}

	$(document).ready(function(){
		selectBoardWrite('${param.seq}');

		
		$("#saveBtn").on('click', function() {
			
			var form = $('#fileFrom')[0];
	        var formData = new FormData(form);
	        
	        formData.append("fileObj", $("#file1")[0].files[0]);
	        
			$.ajax({
				url:'/multipartUpload',
				enctype: 'multipart/form-data', // 필수
				method:'post',
				data: formData,		// 필수
				processData: false,	// 필수
				contentType: false,	// 필수
				cache: false,
				async: false, //동기
				success: function (result){
					
					if(result.length == 1 ){
						result = result[0];	
					}
					
					
					var board = {
							subject : $("#subject").val(),
							name : $("#name").val(),
							seq :$("#seq").val(),
							memo :$("#memo").val(),		
							local_file_name : result
						};
						
						$.ajax({
							url:'/boardWriteInsert',
							method:"post",
							data:board,
							success: function(resData, textStatus, jqHXR){
								if(resData == "1"){
									alert("저장성공!");
								}
							}
						});
						
				},
				error: function (e) {
					alert("파일업로드실패 : "+result);
				}			
				
			});				
			/*
			var board = {
				subject : $("#subject").val(),
				name : $("#name").val(),
				seq :$("#seq").val(),
				memo :$("#memo").val()		
			};
			
			$.ajax({
				url:'/boardWriteInsert',
				method:"post",
				data:board,
				success: function(resData, textStatus, jqHXR){
					if(resData == "1"){
						alert("저장성공!");
					}
				}
			})
			*/

			
		});
		
		
		
		
	});
	</script>

</head>
<body>
<!-- UI Object -->

	<fieldset>
		<legend>글작성</legend>

		
		
		<div class="form-group">		
		    <input type="text" class="form-control" id="subject" name = "subject" placeholder="제목을입력하세요" >
		 </div>
		<div class="form-group">		
		    <input type="text" class="form-control" id="name" name = "name" placeholder="이름" >
		 </div>		 
		  <div>
		    <label for="exampleFormControlTextarea1">내용</label>
		    <textarea class="form-control" name="memo" id="memo" rows="3"></textarea>
		  </div>
		  <form id='fileFrom' method='post' enctype='multipart/form-data' >
		  	<label for="file1">파일 첫 번째</label>
		  	<input type="file" id="file1" name="file1" required="required" />		  	
		  </form>
		  <div>
		  	<button id="saveBtn">저장</button>
		  	
		  </div>
			
			
		
		

		<input hidden="true" type="text" name="seq" id="seq" title="레이블 텍스트" class="i_text" value="0" >

	</div>
	</fieldset>

<!-- //UI Object -->
</body>
</html>

