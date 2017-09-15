<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Insert title here</title>
	</head>
	<body>
		<h1>Acceso a usuario</h1>
   		<form name='f' action="j_spring_security_check" method='POST'>
      		<table>
         		<tr>
            		<td>Usuario:</td>
            		<td><input type='text' name='usuario' value=''></td>
         		</tr>
         		<tr>
            		<td>Contraseña:</td>
            		<td><input type='password' name='clave' /></td>
         		</tr>
         		<tr>
            		<td><input name="submit" type="submit" value="Accesar" /></td>
         		</tr>
      		</table>
  		</form>
	</body>
</html>