package model;

import java.io.Serializable;

public class UrnaEleitoral implements Serializable {

    private int votos;
    private int serial;
    private boolean aberta;
    private SecaoEleitoral secao;

    public int getVotos() {
        return votos;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public boolean getAberta() {
        return aberta;
    }

    public void setAberta(boolean aberta) {
        this.aberta = aberta;
    }

    public SecaoEleitoral getSecao() {
        return secao;
    }

    public void setSecao(SecaoEleitoral secao) {
        this.secao = secao;
    }

    @Override
    public String toString() {
        return "Serial: " + this.serial + ", " + this.secao;
    }

}
