<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*, model.*" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="dao" class="dao.mockdb.MockDAO" scope="application"></jsp:useBean>
<jsp:useBean id="parameter" class="model.html.ObjectWithId"/>
<jsp:setProperty property="*" name="parameter"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${dao.getJednostkaById(parameter.id).nazwa}
<%
	List<Osoba> pracownicy =dao.getJednostkaById(parameter.getId()).getPracownicy();
	for(model.Osoba o : pracownicy){
		out.append(o.getImie()+" "+o.getNazwisko());
		out.append("<br/>");
	}
%>
<br/>
A teraz z jstl
<br/>
<c:forEach items="${dao.getJednostkaById(parameter.id).pracownicy}" var="o">
<a href="osoba.jsp?id=${o.id}" >${o.imie} ${o.nazwisko}</a><br/>
</c:forEach>

</body>
</html>