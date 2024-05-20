<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jqueryAjax01.jsp</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#img").on("click", function() {
			console.log("뽀로로 클릭함")
			//이미지를 클릭하면 after.PNG
			//수정 -> attr  (attribute)
			console.log($("#img").attr("src"));
			/* $("#img").attr("src","../images/after.PNG"); */
			
			//ajax가 함수다. 옵션이 여러가지면 JSON으로 한 번에 줄 수 있다.
			$.ajax({
				url: "getJSON.jsp",
				type: "get",
				dataType: "html", //전송받을 데이터는 : html, json, xml 가능
				data : {"id":"aaa"},	//getJSON.jsp?id=aaa  이렇게 요청하겠다는 뜻
				/* success : 함수명,
				error : 함수명 */
				success : function(response, status, request){
					console.log("성공시 메세지 출력");
					console.log(response);
					$("img").attr("src", response);
				},
				error : function(response, status, request){
					  console.log("에러 메시지 출력");
					    $("img").attr("src", "https://celclipmaterialprod.s3-ap-northeast-1.amazonaws.com/16/63/1816316/thumbnail?1679473742");
					},
				complete : function(){
					console.log("AJAX 통신 끝");
					$("img").fadeIn(2000);
				},
				beforeSend : function(){
					console.log("요청 보내기 전에 호출됨");
					$("img").fadeOut(2000);
				}
						
			});
			
		})
	})
</script>


</head>
<body>
	<!-- jquery를 사용해서 이미지를 클릭하면 콘솔에 메시지 출력
	스니챗 가져오고
	스크립트에 $펑션으로~~
	
	-->


	<img src="../images/before.PNG" alt="" id="img" />

</body>
</html>