/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import interfaces.Pessoa;

/**
 *
 * @author rafael
 */
public class Mulher extends Pessoa {

    public Mulher(String nome) {
        this.nome = nome;
        System.out.println("Olá Senhora " + this.nome);
    }

}
