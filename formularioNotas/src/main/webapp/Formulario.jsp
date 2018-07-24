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
            Nome: <input type="text" name="nome" placeholder="Digite seu nome" value="<%=request.getParameter("nome") != null ? request.getParameter("nome") : ""%>"/> 
            <%if(request.getAttribute("msgErroNome") != null){%>
            <%=request.getAttribute("msgErroNome")%> <%-- printa o atributo "tamNome" --%>
            <%}%>
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
            
            Nota 1: <input type="text" name="nota1" placeholder="Digite sua nota 1" value="<%=request.getParameter("nota1") != null ? request.getParameter("nota1") : ""%>"/>
            <%if(request.getAttribute("msgErroNota1") != null){%>
            <%=request.getAttribute("msgErroNota1")%>
            <%}%>
            <br><br>
            
            Nota 2: <input type="text" name="nota2" placeholder="Digite sua nota 2" value="<%=request.getParameter("nota2") != null ? request.getParameter("nota2") : ""%>"/>
            <%if(request.getAttribute("msgErroNota2") != null){%>
            <%=request.getAttribute("msgErroNota2")%>
            <%}%>
            <br><br>
            
            VS: <input type="text" name="vs" placeholder="Digite sua VS" value="<%=request.getParameter("vs") != null ? request.getParameter("vs") : ""%>"/>
            <%if(request.getAttribute("msgErroVs") != null){%>
            <%=request.getAttribute("msgErroVs")%>
            <%}%>
            <br><br>
            
            <button type="submit"> Enviar </button>
        </form>
    </body>
</html>
