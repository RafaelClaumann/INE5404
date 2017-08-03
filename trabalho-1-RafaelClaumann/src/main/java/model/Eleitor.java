package model;

import exceptions.EEntradaInvalida;
import exceptions.EObjetoJaDefinido;
import java.io.Serializable;

public class Eleitor implements Serializable {

    private String nome;
    private String cpf;
    private int numeroTitulo;
    private SecaoEleitoral secaoEleitoral;
    private ZonaEleitoral zonaEleitoral;
    private String endereco;
    private boolean votou;

    public Eleitor() {
    }

    public Eleitor(String nome, String cpf, int numeroTitulo, SecaoEleitoral secaoEleitoral, ZonaEleitoral zonaEleitoral, String endereco) {
        this.nome = nome;
        this.cpf = cpf;
        this.numeroTitulo = numeroTitulo;
        this.secaoEleitoral = secaoEleitoral;
        this.zonaEleitoral = zonaEleitoral;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws EEntradaInvalida {
        if (cpf.length() >= 5) {
            this.cpf = cpf;
        } else {
            throw new EEntradaInvalida("O CPF do eleitor deve conter até 5 caracteres!");
        }
    }

    public int getNumeroTitulo() {
        return numeroTitulo;
    }

    public void setNumeroTitulo(int numeroTitulo) {
        this.numeroTitulo = numeroTitulo;
    }

    public SecaoEleitoral getSecaoEleitoral() {
        return secaoEleitoral;
    }

    public void setSecaoEleitoral(SecaoEleitoral secaoEleitoral) {
        this.secaoEleitoral = secaoEleitoral;
    }

    public ZonaEleitoral getZonaEleitoral() {
        return zonaEleitoral;
    }

    public void setZonaEleitoral(ZonaEleitoral zonaEleitoral) {
        this.zonaEleitoral = zonaEleitoral;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public boolean getVotou() {
        return votou;
    }

    public void setVotou(boolean votou) throws EObjetoJaDefinido {
        if (!getVotou()) {
            this.votou = votou;
        } else {
            throw new EObjetoJaDefinido("O eleitor já votou!");
        }
    }

    @Override
    public final String toString() {
        return "nome: " + nome + ", cpf: " + cpf + ", numeroTitulo: " + numeroTitulo + ", endereco: " + endereco + "\n" + secaoEleitoral;
    }

}
