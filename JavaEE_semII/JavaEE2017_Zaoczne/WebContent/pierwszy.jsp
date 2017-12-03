<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<jsp:useBean id="osoba" class="zaj2.Person" scope="session"></jsp:useBean>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Strona jsp</title>
</head>
<body>
<%--${osoba.name="Ada"}
${osoba.surname="Adamska"}
--%>

Cokolwiek ${3+5}

<% 
	String a = "Ala ma kotka";
	a=a+12;
	out.write(a);
	osoba.setName("Karolina");
%>
 Imie: ${osoba.name } <br/>
 Nazwisko: ${osoba.surname}
 <a href="druga.jsp">Idź dalej</a>
 

</body>
</html>