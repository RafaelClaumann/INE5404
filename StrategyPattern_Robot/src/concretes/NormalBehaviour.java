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
public class NormalBehaviour implements IBehaviour {

    @Override
    public int moveCommand() {
        System.out.println("\tNormal Behaviour: if find another robot ignore it");
        return 0;
    }
}
