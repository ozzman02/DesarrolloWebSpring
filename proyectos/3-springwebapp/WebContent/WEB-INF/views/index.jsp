<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<c:import url="/WEB-INF/views/menu.jsp"></c:import>
		<h1>Index.jsp</h1>
		<a href='<c:url value="/about" />'>Acerca de</a><br/>
		<a href='<c:url value="/admin" />'>Gestionar administradores</a><br/><br/>
		
		<!--  Attributos del Model: <c:out value="${mensaje}"></c:out><br/>
		Attributos en Session: <c:out value="${sessionScope.resultado}"></c:out> -->
		
		<c:out value="${adminForm}"></c:out><br/>
		
	</body>
</html>