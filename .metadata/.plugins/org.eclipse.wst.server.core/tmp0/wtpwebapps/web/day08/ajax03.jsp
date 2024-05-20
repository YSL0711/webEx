<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/httpRequest.js"></script>
<script>
	function prt() {
		console.log("prt() 호출 중");

		//search.jsp?txt=뽀로로코딩컴퓨터
		//==> 이미지 경로
		//
		
		let txt = document.querySelector("#txt").value;
		let params = "txt="+txt;
		sendRequest("search.jsp", params, callback, "GET");
		
	}
	function callback(){
		if(xhr.readyState ==4 && xhr.status ==200){
			console.log(xhr.responseText);
			let img = document.querySelector("#img");
			img.src=xhr.responseText;
			
		}

	}
</script>

</head>
<body>

	<input type="text" name="txt" id="txt" />
	<input type="button" value="출력" onclick="prt()" />

	<div id="myconsole">
		<img src="../images/before.PNG" alt="뽀로로"  id="img"/>
	</div>


</body>
</html>