<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
		<script type="text/javascript" src='<c:url value="/res/js/jquery.js" />'></script>
		<script type="text/javascript">
			jQuery(document).ready(function() {
				jQuery(".confirm").on("click", function() {
					return confirm("Si eliminas este elemento no se podr� recuperar. �Continuar?");
				});
			});
		</script>
	</head>
	<body>
		<h1>Admin.jsp</h1>
		<sf:form action="${pageContext.request.contextPath}/admin/save" method="post" commandName="admin">
			<table>
				<!-- <input name="estado" type="text" /> En el controller usar @RequestParam -->
				<c:if test="${admin.idAd ne 0 }">
					<sf:input path="idAd" type="hidden"/>
					<sf:input path="fechaCreacion" type="hidden"/>
				</c:if>
				<tr>
					<td>Nombre</td>
					<td><sf:input path="nombre" type="text"/></td>
				</tr>
				<tr>
					<td>Cargo</td>
					<td><sf:input path="cargo" type="text"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Guardar cambios"/></td>
				</tr>
			</table>
		</sf:form><br/>
		<c:out value="${resultado}"></c:out><br/><br/>
		<c:forEach items="${admins}" var="admin">
			<c:out value="${admin}"></c:out>
			<a href='<c:url value="/admin/${admin.idAd}/update" />'>Actualizar</a>
			<a class="confirm" href='<c:url value="/admin/${admin.idAd}/delete" />'>Eliminar</a><br/>
		</c:forEach>
	</body>
</html>