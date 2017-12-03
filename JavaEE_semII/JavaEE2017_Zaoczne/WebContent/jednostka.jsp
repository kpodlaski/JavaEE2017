<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="jedn_id" class="model.jsp.ObjectWithId" scope="page">
</jsp:useBean>
<jsp:setProperty property="*" name="jedn_id"/>
<jsp:useBean id="dao" class="dao.DAOWithoutDBImpl" scope="application"></jsp:useBean>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${jedn_id.id}
${dao.getJednostkaById(jedn_id.id).nazwa}
</body>
</html>