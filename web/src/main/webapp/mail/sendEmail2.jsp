<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.PasswordAuthentication"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sendEmail2.jsp</title>
</head>
<body>
   <%
      Properties p = new Properties();
      
      //구글 설정
      p.put("mail.transport.protocol", "smtp");
      p.put("mail.smtp.host", "smtp.gmail.com");
      p.put("mail.smtp.auth", "true");
      p.put("mail.smtp.port", "465");
      
      p.put("mail.smtp.quitwait", "false");
      p.put("mail.smtp.socketFactory.port", "465");
      p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
      p.put("mail.smtp.socketFactory.fallback", "false");
      
      // 보낼 메시지
      StringBuffer sb = new StringBuffer();
      
      sb.append("<h3> 올리비아 로드리고 첫 내한공연 라이브네이션 선예매 </h3>");
      
      sb.append("<h3> 2024.09.20 ~ 09.21 </h3>");
      
      String code = ""+(int)(Math.random()*10000);
      
      sb.append("<h3> 승인번호는 "+code+"입니다</h3>");
      
      // 보내는 사람 이메일
      /* String username = "본인메일계정"; */
      String username = "dldustj1234@gmail.com";
      
      // 보내는 사람 비번
      /* String password = "본인비밀번호"; */
      /* 구글 스페이스 없음 */
      String password = "guefbibhskmlbkly";
           
      // 받는 사람 이메일
      String receiver = "dldustj1234@hanmail.net";
      
      // javax.mail.Session
      Session sessions = Session.getInstance(p, new Authenticator(){
    	  protected PasswordAuthentication getPasswordAuthentication(){
    		  return new PasswordAuthentication(username, password);
    	  }
      });
      
      System.out.println("sessions : " + sessions);
      
      String title = "test 인증번호입니다";
      
      Message message = new MimeMessage(sessions);
      message.setFrom(new InternetAddress("dldustj1234@naver.com", "test", "utf-8"));
      message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiver));
      message.setSubject(title);
      message.setContent(sb.toString(), "text/html;charset=utf-8");
      Transport.send(message);
      
   %>
</body>
</html>