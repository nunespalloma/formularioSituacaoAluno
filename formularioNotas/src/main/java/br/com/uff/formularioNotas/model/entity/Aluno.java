 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uff.formularioNotas.model.entity;

import java.util.ArrayList;

/**
 * Classe modelo para representar os alunos.
 * @author palloma
 * @version 1.0
 */
public class Aluno {
    /**
    * Atributo que representa o nome dos alunos.
    */
    private String nome = "";
    /**
    * Atributo que representa a primeira nota dos alunos.
    */
    private double nota1 = 0.0;
    /**
    * Atributo que representa a segunda nota dos alunos.
    */
    private double nota2 = 0.0;
    /**
    * Atributo que representa a verificação suplementar dos alunos.
    */
    private double vs = 0.0;
    /**
    * Atributo que representa o resultado final dos alunos, na disciplina.
    */
    private String resultado = "";

    private String sexo = "";
    
    private String curso = "";
    
    /**
    * Metodo construtor da classe aluno.
    */
    public Aluno() {
    }

    /**
    * Metodo construtor da classe aluno, com todos os parâmetros de entrada.
    */
    public Aluno(String nome, double nota1, double nota2, double vs, String sexo, String curso) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.vs = vs;
        this.sexo = sexo;
        this.curso = curso;
    }

    /**
    * Metodo get do atributo nome.
    */
    public String getNome() {
        return nome;
    }

    /**
    * Metodo get do atributo nota 1.
    */
    public double getNota1() {
        return nota1;
    }

    /**
    * Metodo get do atributo nota 2.
    */
    public double getNota2() {
        return nota2;
    }

    /**
    * Metodo get do atributo vs.
    */
    public double getVs() {
        return vs;
    }

    public String getResultado() {
        return resultado;
    }

    public String getSexo() {
        return sexo;
    }

    public String getCurso() {
        return curso;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public void setVs(double vs) {
        this.vs = vs;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public boolean verificar(){
        boolean valor;
        double media = (this.nota1 + this.nota2) / 2;
        if(media >= 6.0){
            valor = true;
        }
        else if(media < 6 && media >= 4){
            media =  (media + this.vs)/2;
            if(media > 6.0){
                valor = true;
            }
            else{
                valor = false;
            }
        }
        else{
             valor = false;   
        }
        return valor;
    }
    
}