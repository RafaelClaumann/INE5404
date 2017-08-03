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
public class PortaContext {
    protected IPortaState estado;
    
    public PortaContext() {
        this.estado = new PortaAberta();
    }
    
    public void abre(){
        this.estado = this.estado.abre();
    }
    
    public void fecha(){
        this.estado = this.estado.fecha();
    }
    
    public void tranca(){
        this.estado = this.estado.tranca();
    }
    
    public void destranca(){
        this.estado = this.estado.destranca();
    }
}
