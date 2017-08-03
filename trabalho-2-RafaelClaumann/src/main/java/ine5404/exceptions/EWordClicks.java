/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404.exceptions;

/**
 *
 * @author rafael
 */
public class EWordClicks extends Exception {

    public EWordClicks() {
        System.out.println("Você já clicou em 5 botões e não encontrou nenhuma palavra");
    }

}
