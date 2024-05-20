/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/10.1.20
 * Generated at: 2024-05-20 02:15:00 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.mail;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.jsp.*;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;
import javax.mail.Session;
import java.util.Properties;

public final class sendEmail2_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports,
                 org.apache.jasper.runtime.JspSourceDirectives {

  private static final jakarta.servlet.jsp.JspFactory _jspxFactory =
          jakarta.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(3);
    _jspx_imports_packages.add("jakarta.servlet");
    _jspx_imports_packages.add("jakarta.servlet.http");
    _jspx_imports_packages.add("jakarta.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(8);
    _jspx_imports_classes.add("javax.mail.Message");
    _jspx_imports_classes.add("javax.mail.internet.InternetAddress");
    _jspx_imports_classes.add("javax.mail.PasswordAuthentication");
    _jspx_imports_classes.add("java.util.Properties");
    _jspx_imports_classes.add("javax.mail.Transport");
    _jspx_imports_classes.add("javax.mail.Session");
    _jspx_imports_classes.add("javax.mail.internet.MimeMessage");
    _jspx_imports_classes.add("javax.mail.Authenticator");
  }

  private volatile jakarta.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public boolean getErrorOnELNotFound() {
    return false;
  }

  public jakarta.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final jakarta.servlet.http.HttpServletRequest request, final jakarta.servlet.http.HttpServletResponse response)
      throws java.io.IOException, jakarta.servlet.ServletException {

    if (!jakarta.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final jakarta.servlet.jsp.PageContext pageContext;
    jakarta.servlet.http.HttpSession session = null;
    final jakarta.servlet.ServletContext application;
    final jakarta.servlet.ServletConfig config;
    jakarta.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    jakarta.servlet.jsp.JspWriter _jspx_out = null;
    jakarta.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>sendEmail2.jsp</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("   ");

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
      
   
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof jakarta.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
