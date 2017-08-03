/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404.porta.state;

import ine5404.interfaces.IPortaState;

/**
 *
 * @author martin
 */
public class PortaFechada implements IPortaState{

    @Override
    public IPortaState abre() {
        System.out.println("Abriu!");
        return new PortaAberta();
    }

    @Override
    public IPortaState fecha() {
        System.out.println("Já está fechada!");
        return this;
    }

    @Override
    public IPortaState tranca() {
        System.out.println("Trancou!");
        return new PortaTrancada();
    }

    @Override
    public IPortaState destranca() {
        System.out.println("A porta deve ser primeiro trancada!");
        return this;
    }
    
}
