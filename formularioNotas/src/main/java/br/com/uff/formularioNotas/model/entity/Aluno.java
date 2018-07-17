/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.uff.formularioNotas.model.entity;

import java.util.ArrayList;

/**
 * Classe modelo para representar os alunos.
 *
 * @author palloma
 * @version 1.0
 */
public class Aluno {

    private String nome = "";
    private double nota1 = 0.0;
    private double nota2 = 0.0;
    private double vs = 0.0;
    private boolean resultado = false;

    public Aluno() {
    }

    public Aluno(String nome, double nota1, double nota2, double vs) {
        this.nome = nome;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.vs = vs;
    }

    public String getNome() {
        return nome;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getVs() {
        return vs;
    }

    public boolean isResultado() {
        return resultado;
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

    public void setResultado(boolean resultado) {
        this.resultado = resultado;
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