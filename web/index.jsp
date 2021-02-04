<%-- 
    Document   : index
    Created on : 29 de jan. de 2021, 09:25:33
    Author     : jhons
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>   
<%@ page import="org.postgresql.Driver" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Conexao">
            <label for="num1">Número 1</label>
                <input id="num1" name="num1">
            <br>
            <label for="num2">Número 2</label>
                <input id="num1" name="num2">
            <br>
            <select name="operacao">
                <option value="+">Somar</option>
                <option value="-">Subtrair</option>
                <option value="*">Multiplicar</option>
                <option value="/">Dividir</option>
            </select>
            <br>
                <input type="submit" value="Calcular">
        </form>
  
    </body>
</html>
