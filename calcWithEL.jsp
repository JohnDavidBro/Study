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
<jsp:useBean id="myReq" scope="page" class="www.dream.bb.model.CalcReqEL" />
<jsp:setProperty name="myReq" property="*" />
${myReq.calc()}<br>
<!-- 설정된 getOpFt 값을 표시  -->
${myReq.opFt}
<!-- 설정된 Arr 배열값을 표시  -->
${myReq.arr[1]}
</body>
</html>