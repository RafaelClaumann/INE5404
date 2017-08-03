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
public class DefensiveBehaviour implements IBehaviour {

    @Override
    public int moveCommand() {
        System.out.println("\tDefensive Behaviour: if find another robot run from it");
        return -1;
    }
}
