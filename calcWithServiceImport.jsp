<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="www.dream.bb.service.SCalc"%>
    <!-- import(필요에 의해 강제로 넣음) //  -->
    <!-- C:\IDE\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\work\Catalina\localhost  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSP 통한 계산 결과
	
	내장 객체 (compile된 코드들)<br>
<code>
	final jakarta.servlet.jsp.PageContext pageContext;<br>
    jakarta.servlet.http.HttpSession session = null;<br>
    final jakarta.servlet.ServletContext application;<br>
    final jakarta.servlet.ServletConfig config;<br>
    jakarta.servlet.jsp.JspWriter out = null;<br>
    final java.lang.Object page = this;<br>
</code>


 <!-- 의존했다. -->
<%= SCalc.calc(request)%>

</body>
</html>