<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registro</title>
</head>
<body>
<h1>Registro</h1>
<form action="http://localhost:8080/DNIE/Registro" method=post>
Nombre: <input type=text name=nombre maxlength="30" required/>
Apellido1: <input type=text name=apellido1 maxlength="30" required/>
Apellido2: <input type=text name=apellido2 maxlength="30" required/>
DNI: <input type=text name=nif maxlength="30" required/>
<input type=submit value=Send>
</form>
</body>
</html>