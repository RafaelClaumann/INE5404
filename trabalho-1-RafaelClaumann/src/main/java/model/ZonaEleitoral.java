package model;

import exceptions.EEntradaInvalida;
import java.io.Serializable;
import java.util.ArrayList;

public class ZonaEleitoral implements Serializable {

    private int numero;
    private String localizacao;
    private ArrayList<SecaoEleitoral> secoesEleitorais;

    public ZonaEleitoral() {
    }

    public ZonaEleitoral(int numero, String localizacao, ArrayList<SecaoEleitoral> secoesEleitorais) {
        this.numero = numero;
        this.localizacao = localizacao;
        this.secoesEleitorais = secoesEleitorais;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) throws EEntradaInvalida {
        if (localizacao.length() >= 5) {
            this.localizacao = localizacao;
        } else {
            throw new EEntradaInvalida("Digite os caracteres da forma correta!");
        }
    }

    public ArrayList<SecaoEleitoral> getSecoesEleitorais() {
        return secoesEleitorais;
    }

    public void setSecoesEleitorais(ArrayList<SecaoEleitoral> secoesEleitorais) {
        this.secoesEleitorais = secoesEleitorais;
    }

    @Override
    public String toString() {
        return "Zona Eleitoral: " + numero + ", localizacao: " + localizacao;
    }

}
