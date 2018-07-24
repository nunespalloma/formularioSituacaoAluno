<%-- 
    Document   : Historico
    Created on : 17/07/2018, 00:05:57
    Author     : pallo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="br.com.uff.formularioNotas.model.entity.Aluno"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
        <title>Histórico</title>
    </head>
    <body>
        <table border = "1">
            <tr>
                <td> Nome </td>
                <td> Nota 1 </td>
                <td> Nota 2 </td>
                <td> Vs </td>
                <td> Sexo </td>
                <td> Curso </td>
                <td> Resultado </td>
            </tr>
            <core:forEach items="${applicationScope.alunos}" var="aluno">  <%--"alunos": é nome entre aspas na servlet --%>
                <tr>
                    <td>${aluno.nome}</td>
                    <td>${aluno.nota1}</td>
                    <td>${aluno.nota2}</td>
                    <td>${aluno.vs}</td>
                    <td>${aluno.sexo}</td>
                    <td>${aluno.curso}</td>
                    <td>${aluno.resultado}</td>
                </tr>
            </core:forEach>
        </table>
    </body>
</html>
