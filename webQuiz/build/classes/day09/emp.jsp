<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emp.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
	<script>
	window.onload = function(){
		$("#btn1").on("click", idSearch);
		
		function idSearch(){
			let search = $("#empno").val().trim();
			
			$.ajax({
				url : "search2.jsp",
				dataType : "html",
				data : {"empno" : search },
				success : function(response, status, request){
					console.log("비동기 통신 : ");
					console.log(response);
				}
			});
		}
		
	}
	</script>
</head>
<body>
	<!-- 
	search2.jsp?empno=7788
	 -->
	 <input type="text" name="empno" id="empno" />
	 <input type="button" value="검색" id="btn1" />
	 
	 <div id="info">
	 <h6>사원번호</h6>
	 <h6>사원명</h6>
	 <h6>직무</h6>	 
	 <h6>급여</h6>
	 </div>
	 
</body>
</html>