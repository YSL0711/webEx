<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	//dept.xml 파일에서 부서명과 부서위치를 리스트로 출력
	$(function(){
		$("input").on("click", function(){
			$.ajax({
				url:"dept.xml",
				datatype: "xml",
				success: function(data){
					let dept = $(data).find("dept");
					data.each(function(){
						let deptno = $(this).find("deptno").text();
						let dname = $(this).find("dname").text();
						let loc = $(this).find("loc").text();
						
						let txt = "<li>" + deptno + " : " + dname + " : " + loc + "</li>";
						$("ul").append(txt);
					})
				}
			});
		})	
	})
	
	//10 : ACCOUTING : NEW YORK
</script>
</head>
<body>
	<h3>부서리스트</h3>
	<input type="button" value="부서가져오기" />
	<div>
		<ul>
			<li>
				<h2>부서리스트</h2>
			</li>
		</ul>
	</div>
</body>
</html>