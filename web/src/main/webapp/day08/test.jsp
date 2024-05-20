<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test.jsp</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
   // 버튼을 클릭하면 show() 함수 호출
   /* $(function(){
      $("#btn").on("click", show);
   }) */
   
   window.onload = function() {
      let btn = document.querySelector(".btn2");
      /* btn.addEventListener("이벤트종류", 함수명); */
      btn.addEventListener("click", show);
      //btn.addEventListener("click", show1);
      //btn.onclick = show;
      //btn.onclick = show1;
   }
   
   function show() {
      alert("show 함수 호출");
      
      let w = 300;
      let h = 300;
      let x = 100;
      let y = 100;
      let spec = "width="+w+",height="+h+",left="+x+",top="+y
            +",menubar=0,resizable=0,scrollbars=0,status=0,toolbar=0";
      
      window.open("newPage.jsp", "_blank", spec);
   }
</script>
</head>
<body>
   <input type="text" name="txt2" id="txt2" />
   <input type="button" value="버튼" class="btn2" id="btn" />
</body>
</html>