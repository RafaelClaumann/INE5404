/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import factory.FactoryPessoa;

/**
 *
 * @author rafael
 */
public class TesteApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FactoryPessoa factory = new FactoryPessoa();
        
        String nome = "Carlos";
        String sexo = "M";
        factory.getPessoa(nome, sexo);
    }

}
