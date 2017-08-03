package model;

import java.io.Serializable;
import java.util.ArrayList;

public class SecaoEleitoral implements Serializable {

    private int numero;
    private ZonaEleitoral zonaEleitoral;
    private ArrayList<Eleitor> eleitores;
    private UrnaEleitoral urna;

    public SecaoEleitoral() {
    }

    public SecaoEleitoral(int numero, ArrayList<Eleitor> eleitores) {
        this.numero = numero;
        this.eleitores = eleitores;
    }

    public SecaoEleitoral(int numero, ZonaEleitoral zonaEleitoral, ArrayList<Eleitor> eleitores) {
        this.numero = numero;
        this.zonaEleitoral = zonaEleitoral;
        this.eleitores = eleitores;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public ArrayList<Eleitor> getEleitores() {
        return eleitores;
    }

    public void setEleitores(ArrayList<Eleitor> eleitores) {
        this.eleitores = eleitores;
    }

    public ZonaEleitoral getZonaEleitoral() {
        return zonaEleitoral;
    }

    public void setZonaEleitoral(ZonaEleitoral zonaEleitoral) {
        this.zonaEleitoral = zonaEleitoral;
    }

    public UrnaEleitoral getUrna() {
        return urna;
    }

    public void setUrna(UrnaEleitoral urna) {
        this.urna = urna;
    }

    @Override
    public String toString() {
        return "Secao Eleitoral: " + numero + ", " + zonaEleitoral + "\n";
    }

}
