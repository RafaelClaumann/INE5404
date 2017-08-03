package model;

import java.io.Serializable;

public class Vereador extends Eleitor implements Serializable {

    private int numero;
    private int votos;
    private PartidoPolitico partidoPolitico;

    public Vereador() {
    }

    /*    public Vereador(int numero, PartidoPolitico partidoPolitico) {
    this.numero = numero;
    this.partidoPolitico = partidoPolitico;
    }
    
    public Vereador(int numero, PartidoPolitico partidoPolitico, String nome, String cpf, int numeroTitulo, SecaoEleitoral secaoEleitoral, ZonaEleitoral zonaEleitoral, String endereco) {
    super(nome, cpf, numeroTitulo, secaoEleitoral, zonaEleitoral, endereco);
    this.numero = numero;
    this.partidoPolitico = partidoPolitico;
    }*/
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public PartidoPolitico getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(PartidoPolitico partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

}
