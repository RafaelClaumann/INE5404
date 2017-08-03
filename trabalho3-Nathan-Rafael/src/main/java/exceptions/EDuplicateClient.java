/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

/**
 *
 * @author nathancezar
 */
public class EDuplicateClient extends Exception {

    @Override
    public String toString() {
        return "Cliente Já Registrado!";
    }
}
