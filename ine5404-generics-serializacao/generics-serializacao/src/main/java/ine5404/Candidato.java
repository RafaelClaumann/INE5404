/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404;

import java.io.Serializable;

/**
 *
 * @author martin.vigil
 */
public class Candidato implements Serializable {
    protected int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    protected String nome;
    
    public Candidato(int numero, String nome){
        this.numero = numero;
        this.nome = nome;                
    }
}
