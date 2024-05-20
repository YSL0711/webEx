<%@page import="java.util.Set"%>
<%@page import="vo.ProductVO"%>
<%@page import="dao.ProductDAO"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
img {
	width: 100px;
	height: 100px;
}

table {
	border-top: 5px solid black;
	border-bottom: 5px solid black;
	margin: 0 auto;
	width: 800px;
}
</style>
<body>
	<table>
		<tr>
			<th>상품번호</th>
			<th>상품명</th>
			<th>이미지</th>
			<th>수량</th>
			<th>할인가격</th>
		</tr>

		<%
		// session 에서 cart속성 가져오기 : obj
		Object obj = session.getAttribute("cart");
		//obj <== null
		if (obj == null) {
			//ArrayList생성
			ArrayList<Integer> cart = new ArrayList<Integer>();
			//세션의 속성 지정
			session.setAttribute("cart", cart);
			//다시 가져오기
			obj = session.getAttribute("cart");
		}
		//ArrayList 형변환
		//아래코드부터는 obj가 반드시 존재하게 된다.

		ArrayList<Integer> cart = (ArrayList<Integer>) obj;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		//1개씩 꺼내서 상품과 수량을 집계
		for (Integer it : cart) {
			//n번 상품이 존재한다면
			if (map.containsKey(it)) {
				//현재 상품의 개수 구하기
				int cnt = map.get(it);
				//상품개수에 1 증가시키기
				cnt++;
				//그리고 다시 맵에 넣기
				map.put(it, cnt);
			} else {
				map.put(it, 1);
			}
			System.out.println("map : " + map);
		}
		//화면에 표형태로 출력

		Set key = map.keySet(); //상품번호만 set타입으로 리턴

		ProductDAO dao = new ProductDAO();

		ArrayList<ProductVO> item = dao.getData(key);

		int total = 0;

		for (ProductVO vo : item) {
			int cnt= map.get(vo.getPno());
			total += Math.round(vo.getPrice()*(1-vo.getDcratio()*0.01))*cnt;
		%>
		<tr>
			<td><%=vo.getPno()%></td>
			<td><%=vo.getPname()%></td>
			<td><img src="<%=vo.getImgfile()%>" alt="<%=vo.getPname()%>" /></td>
			<td><%= cnt %></td>
			<%-- <td><%= vo.getPrice() %></td> --%>
			<td><%=Math.round(vo.getPrice()*(1 - vo.getDcratio()*0.01))%></td>
		</tr>

		<%
		}
		%>

		<tr>
			<td colspan="4">합계</td>
			<td>
				<% total %>	</td>
		</tr>

		<tr>
			<td colspan="5">
			<input type="button" value="결제하기" />
			</td>
			<td></td>
		</tr>

	</table>
</body>
</html>