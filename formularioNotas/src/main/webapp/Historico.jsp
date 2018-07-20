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
        <title>Histórico</title>
    </head>
    <body>
        <% ArrayList<Aluno> alunos = (ArrayList<Aluno>) getServletContext().getAttribute("alunos");%>
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
        <% for (int i=0;i<alunos.size();i++){%>
            <tr>
                <td><%=alunos.get(i).getNome()%></td>
                <td><%=alunos.get(i).getNota1()%></td>
                <td><%=alunos.get(i).getNota2()%></td>
                <td><%=alunos.get(i).getVs()%></td>
                <td><%=alunos.get(i).getSexo()%></td>
                <td><%=alunos.get(i).getCurso()%></td>
                <td><%=alunos.get(i).getResultado()%></td>
            </tr>
        <%}%>
        </table>
    </body>
</html>
