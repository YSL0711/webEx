
<%@page import="vo.ProductVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dao.ProductDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//search.jsp?txt=뽀로로코딩컴퓨터

String pname = request.getParameter("txt");
if (pname != null) {
	ProductDAO dao = new ProductDAO();
	ArrayList<ProductVO> list = dao.findByName(pname);

	if (list != null) {
		out.println(list.get(0).getImgfile());
	}
}
%>