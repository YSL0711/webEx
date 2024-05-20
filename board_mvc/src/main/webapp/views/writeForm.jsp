<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>writeForm.jsp</title>
<!-- include libraries(jQuery, bootstrap) -->
<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- include summernote css/js -->
<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
<script>
	$(function(){
		$(".summernote").summernote({
			heiget:150,
			lang:"ko-KR"
		});
	})
</script>
</head>
<body>
	<!-- 4개의 파라미터를 가지고 .board.do?cmd=writeOk ==> WriteAction ==> .db에 insert
다시 list로 리다이렉트
 -->

	<div class="container">
		<form action="board.do" method="get">
			<table class="table table-striped">
				<tr>
					<th>작성자</th>
					<td>
						<input type="text" name="writer" />
						<input type="hidden" name="cmd" value="writeOk" />
					</td>
				</tr>

				<tr>
					<th>제목</th>
					<td><input type="text" name="title" /></td>
				</tr>

				<tr>
					<th>내용</th>
					<td><textarea class="summernote" name="contents" id="" cols="30" rows="10"></textarea>
					
				</tr>
				<tr>
					<td colspan="2" >
						<input class="btn btn-success" type="button" value="목록" />
						<input class="btn btn-primary" type="submit" value="작성" />
						<input class="btn btn-danger" type="reset"	value="다시 쓰기" />
						</td>
				</tr>
			</table>


		</form>
	</div>

</body>
</html>