<%-- 
    Document   : Formulario
    Created on : 16/07/2018, 23:12:47
    Author     : pallo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
        <title>Formulario</title>
    </head>
    <body>
        <form action="FormularioServlet" method="POST">
            Nome: <input type="text" name="nome" placeholder="Digite seu nome" value="${param.nome}"/> 
            <core:if test="${not empty requestScope.msgErroNome}">
                ${requestScope.msgErroNome} <%-- printa o atributo "tamNome" --%>
            </core:if>
            <br><br> <%-- pula linha (nesse caso, pulou 2 linhas)--%>
            
            <select name="sexo">
                <option value="Masculino">Masculino</option>
                <option value="Feminino">Feminino</option>
                <option value="Outros">Outros</option>
            </select>
            <br><br>
            
            <select name="curso">
                <option value="Ciencia da Computacao">Ciência da computação</option>
                <option value="Sistemas de Informacao">Sistemas de informação</option>
                <option value="Matematica">Matemática</option>
            </select>
            <br><br>
            
            Nota 1: <input type="text" name="nota1" placeholder="Digite sua nota 1" value="${param.nota1}"/>
            <core:if test="${not empty requestScope.msgErroNota1}">
                ${requestScope.msgErroNota1}
            </core:if>
            <br><br>
            
            Nota 2: <input type="text" name="nota2" placeholder="Digite sua nota 2" value="${param.nota2}"/>
            <core:if test="${not empty requestScope.msgErroNota2}">
                ${requestScope.msgErroNota2}
            </core:if>
            <br><br>
            
            VS: <input type="text" name="vs" placeholder="Digite sua VS" value="${param.vs}"/>
            <core:if test="${not empty requestScope.msgErroNome}">
                <core:out value="${requestScope.msgErroNome}"/> <%-- printa o atributo "tamNome" --%>
            </core:if>
            <br><br>
            
            <button type="submit"> Enviar </button>
        </form>
    </body>
</html>
