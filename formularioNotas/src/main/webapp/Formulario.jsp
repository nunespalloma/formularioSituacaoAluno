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
        <title>Formulario</title>
    </head>
    <body>
        <form action="FormularioServlet" method="POST">
            Nome: <input type="text" name="nome" placeholder="Digite seu nome"/> 
            <%if(request.getAttribute("validacao") == "1"){%>
            <%-- <%=request.getAttribute("tamNome")%> <%-- printa o atributo "tamNome" --%>
            CAMPOS ESCRITOS DE FORMA ERRADA
            <%}%>
            <br><br>
            
            Nota 1: <input type="text" name="nota1" placeholder="Digite sua nota 1"/><br><br>
            Nota 2: <input type="text" name="nota2" placeholder="Digite sua nota 2"/><br><br>
            VS: <input type="text" name="vs" placeholder="Digite sua VS"/><br><br>
            <button type="submit"> Enviar </button>
        </form>
    </body>
</html>
