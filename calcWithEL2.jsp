<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- C:\IDE\.metadata\.plugins\org.eclipse.wst.server.core\tmp1\work\Catalina\localhost  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
JSP 계산 결과
<jsp:useBean id="myReq" scope="page" class="www.dream.bb.model.CalcReqEL2" />
<!-- 내장객체 리퀘스트(요구) -->
${myReq.calc2(request)}

</body>
</html>