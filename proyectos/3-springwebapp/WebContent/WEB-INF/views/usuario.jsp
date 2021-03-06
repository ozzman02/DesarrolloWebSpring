<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script type="text/javascript" src='<c:url value="/res/js/jquery.js" />'></script>
	</head>
	<body>
		<c:import url="/WEB-INF/views/menu.jsp"></c:import>
		<h1>Usuario.jsp</h1>
		<sf:form action="${pageContext.request.contextPath}/usuario/save" method="post" commandName="usuario">
			<table>
				<tr>
					<td>Usuario</td>
					<td>
						<sf:input path="usuario" type="text"/>
						<sf:errors path="usuario" cssStyle='color:red'></sf:errors>
					</td>
				</tr>
				<tr>
					<td>Contraseņa</td>
					<td>
						<sf:input path="clave" type="password"/>
						<sf:errors path="clave" cssStyle='color:red'></sf:errors>
					</td>
				</tr>
				<tr>
					<td>Permiso</td>
					<td>
						<sf:input path="permiso" type="text"/>
						<sf:errors path="permiso" cssStyle='color:red'></sf:errors>
					</td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Guardar cambios"/></td>
				</tr>
			</table>
		</sf:form><br/>
		<c:out value="${resultado}"></c:out><br/><br/>
		<c:forEach items="${usuarios}" var="usuario">
			<c:out value="${usuario}"></c:out><br/>
		</c:forEach>
	</body>
</html>