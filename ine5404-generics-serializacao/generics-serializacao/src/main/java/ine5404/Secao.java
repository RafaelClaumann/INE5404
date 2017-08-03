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
public class Secao implements Serializable {
    protected int numero;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    protected String endereco;
    
    public Secao(int numero, String endereco){
        this.numero = numero;
        this.endereco = endereco;
    }
}
