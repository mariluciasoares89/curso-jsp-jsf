<%@page import="java.text.Normalizer.Form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Curso JSP</title>
</head>

<body>

<h1>Bem vindo ao curso JSP</h1>



<form action="receber-nome.jsp">
<input name= "nome">
<input name= "idade">

<input type= "Submit" value= "Enviar">

</form>
</body>
</html>