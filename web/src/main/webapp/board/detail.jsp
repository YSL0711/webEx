<%@page import="vo.BoardVO"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail.jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<script>
$(function(){
	$(".summernote").summernote({
		heitght:150,
		lang:"ko-KR"
		});
	});
		

	$('.summernote').summernote({ 
		  // 에디터 높이 
		  height: 150, 
		  // 에디터 한글 설정 
		  lang: "ko-KR", 
		  focus : true, 
		  toolbar: [ 
			    // 글꼴 설정 
			    ['fontname', ['fontname']], 
			    // 글자 크기 설정 
			    ['fontsize', ['fontsize']], 
			    // 굵기, 기울임꼴, 밑줄,취소 선, 서식지우기 
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']], 
			    // 글자색 
			    ['color', ['forecolor','color']], 
			    // 표만들기 
			    ['table', ['table']], 
			    // 글머리 기호, 번호매기기, 문단정렬 
			    ['para', ['ul', 'ol', 'paragraph']], 
			    // 줄간격 
			    ['height', ['height']], 
			    // 그림첨부, 링크만들기, 동영상첨부 
			    ['insert',['picture','link','video']], 
			    // 코드보기, 확대해서보기, 도움말 
			    ['view', ['codeview','fullscreen', 'help']] 
			  ], 
			  // 추가한 글꼴 
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','맑은 고딕', '런드리고딕OTF', '궁서','굴림체','굴림','돋움체','바탕체'], 
			 // 추가한 폰트사이즈 
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'] 
		}); 
</script>
</head>
<body>
	<%
		// 1. 전달 받은 파라미터의 값 가져오기 
		String b = request.getParameter("bno");
	
		// 2. b null 이 아니면 
		if(b != null){
		// 3. 숫자로 형변환 
			int bno = Integer.parseInt(b); 
		// 4. dao 객체
			BoardDAO dao = new BoardDAO();
		
			dao.raiseHits(bno);		//hits 값을 1 증가
			
		// 5. dao를 통해서 지정한 게시물을 가져오기 
		// dao.getOne(bno); 
			BoardVO vo = dao.getOne(bno);
		
		
	%>
	
	<div class="container">
	<h2>상세보기</h2>
	
	<!-- table>tr>(th+td)*2 -->
	<table class="table table-hover">
		<tr>
			<th>작성자</th>
			<td><%= vo.getWriter() %></td>
			<th>조회수</th>
			<td><%= vo.getHits() %></td>
			<th>작성일시</th>
			<td><%= vo.getRegdate() %></td>
		</tr>
		<tr>
			<th colspan="2">제목</th>
			<td colspan="4"><%= vo.getTitle() %></td>
		</tr>
		<tr>
			<th colspan="2">내용</th>
			<td colspan="4"><%= vo.getContents() %></td>
		</tr>
		<tr>
			<td colspan="6">
				<a href="list.jsp" class="btn btn-primary">목록</a>
				<a href="modify.jsp?bno=<%= vo.getBno() %>" class="btn btn-success" >수정</a>
				<a href="deleteOk.jsp?bno=<%= vo.getBno() %>" class="btn btn-danger" >삭제</a>
			</td>
		</tr>
	</table> 
	
	</div>
	<%
		}
	%>
</body>
</html>