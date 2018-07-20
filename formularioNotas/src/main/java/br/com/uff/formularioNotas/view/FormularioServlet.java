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
        String sexo = req.getParameter("sexo");
        String curso = req.getParameter("curso");
        String tamNome = "";
        String valorNota = "";
        boolean validacao = true;
        String msgErroNome = null;
        String msgErroNota1 = null;
        String msgErroNota2 = null;
        
        if(nome.length() < 2 || nome.length() > 50){
            //tamNome = "errado";
            //req.setAttribute("tamNome", tamNome);//o atributo "tamNome" é criado
            msgErroNome = "Tamanho para nome inválido.";
            req.setAttribute("msgErroNome", msgErroNome);
            validacao = false;
        }
        if(nota1 > 10 || nota1 < 0){
            //valorNota = "errado";
            //req.setAttribute("valorNota", valorNota);
            msgErroNota1 = "Tamanho para nota 1 inválido.";
            req.setAttribute("msgErroNota1", msgErroNota1);
            validacao = false;
        }
        if(nota2 > 10 || nota2 < 0){
            //valorNota = "errado";
            //req.setAttribute("valorNota", valorNota);
            msgErroNota2 = "Tamanho para nota 2 inválido.";
            req.setAttribute("msgErroNota2", msgErroNota2);
            validacao = false;
        }
        if (validacao == false){
            req.getRequestDispatcher("Formulario.jsp").forward(req, resp);
        }
        else{
            
            Aluno aluno = new Aluno(nome, nota1, nota2, vs, sexo, curso);
            
            if(aluno.verificar()){
                aluno.setResultado("Aprovado");
            }
            else{
                aluno.setResultado("Reprovado");
            }
            
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
            }
            else{
                ArrayList<Aluno> alunos = (ArrayList<Aluno>) req.getServletContext().getAttribute("alunos");
                alunos.add(aluno);
                req.getServletContext().setAttribute("alunos", alunos);
            }
            req.getRequestDispatcher("Historico.jsp").forward(req, resp);
        }
    }
}
