/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404.porta.state;

import ine5404.interfaces.IPortaState;


public class PortaAberta implements IPortaState {

    @Override
    public IPortaState abre() {
        System.out.println("A porta já está aberta!");
        return this;
    }

    @Override
    public IPortaState fecha() {
        System.out.println("Fechou!");
        return new PortaFechada();
    }

    @Override
    public IPortaState tranca() {
        System.out.println("A porta deve ser primeiro fechada!");
        return this;
    }

    @Override
    public IPortaState destranca() {
        System.out.println("A porta deve ser primeiro trancada!");
        return this;
    }
    
}
