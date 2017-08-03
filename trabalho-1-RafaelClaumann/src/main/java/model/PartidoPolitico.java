package model;

import exceptions.EEntradaInvalida;
import exceptions.EObjetoJaDefinido;
import java.io.Serializable;
import java.util.ArrayList;

public class PartidoPolitico implements Serializable {

    private String sigla;
    private String nome;
    private Prefeito prefeito;
    private ArrayList<Vereador> vereadores;

    public PartidoPolitico() {
    }

    public PartidoPolitico(String sigla, String nome) {
        this.sigla = sigla;
        this.nome = nome;
    }

    public PartidoPolitico(String sigla, String nome, Prefeito prefeito, ArrayList<Vereador> vereadores) {
        this.sigla = sigla;
        this.nome = nome;
        this.prefeito = prefeito;
        this.vereadores = vereadores;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) throws EEntradaInvalida {
        if (sigla.length() >= 2) {
            this.sigla = sigla;
        } else {
            throw new EEntradaInvalida("Insira os caracteres da forma correta!");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws EEntradaInvalida {
        if (nome.length() >= 5) {
            this.nome = nome;
        } else {
            throw new EEntradaInvalida("Insira os caracteres da forma correta!");
        }
    }

    public Prefeito getPrefeito() {
        return prefeito;
    }

    public void setPrefeito(Prefeito prefeito) throws EObjetoJaDefinido {
        if (getPrefeito() == null) {
            this.prefeito = prefeito;
        } else {
            throw new EObjetoJaDefinido("O prefeito já foi cadastrado");
        }
    }

    public ArrayList<Vereador> getVereadores() {
        return vereadores;
    }

    public void setVereadores(ArrayList<Vereador> vereadores) {
        this.vereadores = vereadores;
    }

    @Override
    public String toString() {
        return "Sigla: " + this.sigla + ", Nome: " + this.nome + "\n\n--- Prefeito --- \n" + this.prefeito + "\n---Vereadores --- \n" + this.vereadores + "\n";
    }

}
