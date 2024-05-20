<%@page import="vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp</title>
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
		<h2>게시판</h2>

		<a class="btn btn-primary" href="write.jsp">글쓰기</a>
		<table class="table table-hover">
			<tr>
				<th>게시물번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			</tr>
			<%
			BoardDAO dao = new BoardDAO();

			//전체 게시물 건수를 출력
			int totalCount = dao.getTotalCount();

			///////////페이지관련//////////////////////
			//한 페이지 당 게시물 수 : 20
			int recordPerPage = 20;

			//총 페이지 수
			//전체 게시물 건수에 한 페이지당 게시물 수를 나눈다.
			//이 때, 0으로 딱 맞게 떨어진다면 바로 토탈페이지에 대입한다.
			//삼항연산자를 사용해서, 만약 딱 맞게 떨어지지 않는다면 1을 더한다
			//토탈페이지는 0으로 딱 맞게 떨어지지 않으면 1을 더한 수가 된다.
			int totalPage = (totalCount % recordPerPage == 0) ? totalCount / recordPerPage : totalCount / recordPerPage + 1;

			//현재 페이지 번호
			String cp = request.getParameter("cp");

			int currentPage = 0;
			if (cp != null) {
				currentPage = Integer.parseInt(cp);
			} else {
				currentPage = 1;
			}

			//페이지당 시작번호와 끝번호 설정하기
			//1페이지라면 게시물 번호 시작 번호 1: 끝번호 20
			//2페이지 시작번호 21 : 끝번호 40
			//3페이지 시작번호 41 : 끝번호 60
					
			//시작번호 = (1-1)*20+1
			int startNo = (currentPage - 1) * recordPerPage + 1;
			// 	1 => (1-1)*20+1
			// 	2 => (2-1)*20+1
			// 	3 => (3-1)*20+1

			//끝번호 
			int endNo = currentPage * recordPerPage;

			//시작페이지 번호
			int startPage = 1;

			//끝페이지 번호
			int endPage = totalPage;

			//시작페이지를 현재 페이지 기준으로 앞 5개만
			if (currentPage <= 5) {
				startPage = 1;
			} else if (currentPage >= 6) {
				startPage = currentPage - 4;
			}

			//끝페이지는 현재 페이지 기준으로 다음 5개만
			if (totalPage - currentPage <= 5) {
				endPage = totalPage;
			} else if (totalPage - currentPage > 5) {
				if (currentPage <= 5) {
					if (totalPage > 10) {
				endPage = 10;
					} else {
				endPage = totalPage;
					}
				} else {
					endPage = currentPage - 4;
				}
			}

	/* 		out.println("<h6> 총 게시물 수 : " + totalCount + "</h6>");
			out.println("<h6> 페이지당 게시물 건수 : " + recordPerPage + "</h6>");
			out.println("<h6> 총 페이지 수 : " + totalPage + "</h6>");
			out.println("<h6> 현재 페이지 번호 : " + currentPage + "</h6>");
			out.println("<h6> 시작번호 : " + startNo + "</h6>");
			out.println("<h6> 끝번호 : " + endNo + "</h6>"); */

			ArrayList<BoardVO> list = dao.selectAll(startNo, endNo);

			//////////////////////////////////////////////////////////////

			// out.println("list : " + list);
			for (BoardVO vo : list) {
			%>
			<tr>
				<td><%=vo.getBno()%></td>
				<td><a href="detail.jsp?bno=<%=vo.getBno()%>"><%=vo.getTitle()%></a>
				</td>
				<td><%=vo.getWriter()%></td>
				<td><%=vo.getHits()%></td>
			</tr>
			<%
			}
			%>

		 	<tr>
				<td colspan="4">
					<%
					for (int i = startPage; i <= endPage; i++) {
					%> <a href="list.jsp?cp=<%=i%>">[<%=i%>]</a> <%
				
			 }
			 %>
				</td>
			</tr>

			<tr>
				<td colspan="4">
					<nav aria-label="Page navigation example">
						<ul class="pagination">
						
						<%
						for(int i = startPage; i <= endPage; i++) {
							%>
							<li class="page-item"><a class="page-link" href="List.jsp?cp=<%=i%>">[<%=i%>]</a></li>
						<%
						}
						%>
						
						</ul>
					</nav> 
				</td>
			</tr>


		</table>
	</div>
</body>
</html>