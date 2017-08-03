/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package concretes;

import interfaces.IBehaviour;

/**
 *
 * @author rafael
 */
public class AgressiveBehaviour implements IBehaviour {

    @Override
    public int moveCommand() {
        System.out.println("\tAgressive Behaviour: if find another robot attack it");
        return 1;
    }
}
