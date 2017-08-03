/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ine5404;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author martin.vigil
 */
public class Partido implements Serializable {
    protected Candidato prefeito;
    protected List<Candidato> vereadores;

    public Partido(){
        this.vereadores = new ArrayList();
    }
    
    public Candidato getPrefeito() {
        return prefeito;
    }

    public void setPrefeito(Candidato prefeito) {
        this.prefeito = prefeito;
    }

    public List<Candidato> getVereadores() {
        return vereadores;
    }

    public void setVereadores(List<Candidato> vereadores) {
        this.vereadores = vereadores;
    }
    
    public void addPrefeito(Candidato candidato){
        this.vereadores.add(candidato);
    }
}
