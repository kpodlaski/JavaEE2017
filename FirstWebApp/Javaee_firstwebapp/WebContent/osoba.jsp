<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="dao.mockdb.MockDAO" scope="application"></jsp:useBean>
<jsp:useBean id="parameter" class="model.html.ObjectWithId"/>
<jsp:setProperty property="*" name="parameter"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr><td><img src="images/${dao.getOsobaById(parameter.id).fotka}" ><td>
<td>
	<table>
	<tr><td>Imie:</td><td>${dao.getOsobaById(parameter.id).imie}</td></tr>
	<tr><td>Nazwisko:</td><td>${dao.getOsobaById(parameter.id).nazwisko}</td></tr>
	<tr><td>Stanowisko:</td><td>${dao.getOsobaById(parameter.id).stanowisko}</td></tr>
	</table>

</td>
</table>
</body>
</html>