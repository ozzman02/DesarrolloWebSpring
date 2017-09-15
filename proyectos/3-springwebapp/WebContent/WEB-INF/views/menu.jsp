<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h2>Men�</h2>

<sec:authorize access="!isAuthenticated()">
	Por favor inicia sesi�n
</sec:authorize>

<sec:authorize access="isAuthenticated()">
	Usuario ha iniciado sesi�n como: <sec:authentication property="principal" var="principal"/>
	<c:set var="username" value="${principal.username}" />
	<c:out value="${username}"></c:out>
</sec:authorize>