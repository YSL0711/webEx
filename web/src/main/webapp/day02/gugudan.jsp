<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
      for(int i = 1; i <= 9; i++) {
         
      // 표현식 Expression
   %>
      <!-- HTML 주석 : id : aaa -->
      <%-- JSP 주석 : pw : bbb --%>
      <h1>3 * <%=i %> = <%=3*i %></h1>
   <%
      }
   %>
</body>
</html>