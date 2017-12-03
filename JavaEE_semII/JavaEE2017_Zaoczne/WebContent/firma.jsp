<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:useBean id="dao" class="dao.DAOWithoutDBImpl" scope="application"></jsp:useBean>
<title>Firma XABC.CO</title>
</head>
<body>
Lista jednostek :
<br>
<c:forEach items="${dao.getAllJednostka()}" var="jedn">
<a href="jednostka.jsp?id=${jedn.id}">${jedn.nazwa}</a><br>
</c:forEach>

</body>
</html>