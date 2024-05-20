<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>register.jsp</title>
<style>
#buttons {
	text-align: center;
}
</style>

<script>
window.onload = function(){
    let btn = document.getElementById("btn1");
    
    btn.onclick=function(){
        let frm = document.frm;
        
        if(frm[0].value==''){
            alert("ID를 입력하세요");
            frm[0].focus();
            return;
        }
        if(frm[1].value==''){
            alert("이름을 입력하세요");
            frm[1].focus();
            return;
        }
        if(frm[2].value==''){
            alert("비밀번호를 입력하세요");
            frm[2].focus();
            return;
        }
        if(frm[3].value==''){
            alert("성별을 입력하세요");
            frm[3].focus();
            return;
        }
        if(frm[4].value==''){
            alert("가입동기를 입력하세요");
            frm[4].focus();
            return;
        }
        console.dir(frm);
        
        frm.action="registerOk.jsp";
        frm.method="get"; // 여기서 수정됨
        frm.submit();
    }

}
</script>
</head>
<body>

	<form action="registerOk.jsp" name="frm">
    <span>ID: </span>
    <input type="text" name="id" id="id" placeholder="ID를 입력하세요" /> <br>
    
    <span>비밀번호: </span>
    <input type="text" name="pw" id="password" placeholder="비밀번호를 입력하세요" /> <br>    
    
    <span>NAME: </span>
    <input type="text" name="name" id="name" placeholder="이름을 입력하세요" /> <br>
        
    <span>성별: </span>
    <input type="radio" name="gender" id="female" value="여" /> 여
    <input type="radio" name="gender" id="male" value="남" /> 남 <br>
    
    <span>가입동기: </span>
    <textarea name="motive" id="motive" cols="80" rows="5" style="resize: none;"
        placeholder="가입동기를 입력하세요"></textarea>
        
    <div id="button">
        <!-- 가입버튼을 누르면 현재 입력된 값 중 검사 후 올바른 값이 registerOk.jsp로 전달됨 -->
    <input type="button" value="가입하기" id="btn1" />        
    <input type="reset" value="취소하기" id="btn2" />        
    </div>
            
</form>

</body>
</html>