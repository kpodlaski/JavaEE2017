<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${title}</title>
</head>
<body>
<form method="post" action="new">
Nazwa: <input name="name" value="${contact.name}" /><br/>
Tel:  <input name="tel" value="${contact.tel}" />
<input type="submit" value="Send" />
</form>
</body>
</html>