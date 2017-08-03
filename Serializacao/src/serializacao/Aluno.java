/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacao;

import java.io.Serializable;

/**
 *
 * @author rafael
 */
public class Aluno implements Serializable{

    public String nome;
    public String sala;

    public Aluno(String nome, String sala) {
        this.nome = nome;
        this.sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

}
