<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="dao.mockdb.MockDAO" scope="application"></jsp:useBean>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Bardzo ważna firma</title>
</head>
<body>
<ol>
<c:forEach var="element" items="${dao.getAllJednostki()}">
<li> <a href="jednostka.jsp?id=${element.id}">${element.nazwa}</a>
</c:forEach>

</ol>
</body>
</html>