/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uff.formularioNotas.view;

import br.com.uff.formularioNotas.model.entity.Aluno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pallo
 */
@WebServlet("/FormularioServlet")
public class FormularioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        double nota1 = Double.parseDouble(req.getParameter("nota1"));
        double nota2 = Double.parseDouble(req.getParameter("nota2"));
        double vs = Double.parseDouble(req.getParameter("vs"));
        boolean resultado = false;
        String tamNome = "";
        String valorNota = "";
        boolean validacao = true;
        String statusAux = "0";
        
        Aluno aluno = new Aluno(nome, nota1, nota2, vs);
        resultado = aluno.verificar();
        
        if(nome.length() < 2 || nome.length() > 50){
            //tamNome = "errado";
            //req.setAttribute("tamNome", tamNome);//o atributo "tamNome" é criado
            validacao = false;
        }
        if(nota1 < 102 || nota1 > 0){
            //valorNota = "errado";
            //req.setAttribute("valorNota", valorNota);
            validacao = false;
        }
        if (validacao == false){
            statusAux = "1";
            req.setAttribute("validacao", statusAux);
            req.getRequestDispatcher("Formulario.jsp").forward(req, resp);
        }
        else{
            //no caso de entrar nesse if, o atributo "alunos" não existe.
            //Por isso, comparar com null.
            if (req.getServletContext().getAttribute("alunos") == null){ 
                ArrayList<Aluno> alunos = new ArrayList<Aluno>();
                alunos.add(aluno);
                req.getServletContext().setAttribute("alunos", alunos);
                //código para despachar para a pág. do parâmetro, ou seja, 
                //para fazer com que se vá para da página atual para a página do parâmetro.
                //Nesse caso, de Formulário.jsp para Histórico.jsp
                //forward(req,resp) é para que a pág. do parâmetro conheça 
                //os atributos do req (request) e do resp (response) 
                req.getRequestDispatcher("Historico.jsp").forward(req, resp);
            }
            else{
                ArrayList<Aluno> alunos = (ArrayList<Aluno>) req.getServletContext().getAttribute("alunos");
                alunos.add(aluno);
                req.getServletContext().setAttribute("alunos", alunos);
                req.getRequestDispatcher("Historico.jsp").forward(req, resp);
            }
        }
    }
}
