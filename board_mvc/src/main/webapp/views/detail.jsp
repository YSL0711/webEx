<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>
	<div class="container">
		<h2>상세보기</h2>
		<table class="table table-stripe">
<!-- table>tr>(th+td)*3 -->
			<tr>
				<th>작성자</th>
					<td>${vo.writer}</td>
			</tr>
			<tr>		
				<th>조회수</th>
					<td>${vo.hits}</td>
			</tr>
			
			<tr>
				<th>작성일시</th>
					<td>${vo.regdate}</td>
			</tr>
			
				<tr>
					<th>제목</th>
					<td colspan="5">${vo.title}</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td colspan="5">${vo.contents}</td>
				</tr>
				
				<tr>
					<td colspan="6">
						<a class="btn btn-success" href="board.do">목록</a>
						<a class="btn btn-primary" href="board.do?cmd=modify&bno=${vo.bno}" type="button">수정</a>
						<a class="btn btn-danger" href="board.do?cmd=delete&bno=${vo.bno}" type="button">삭제</a>
					</td>
				</tr>
				
			</div>
		</table>


	</div>
</body>
</html>