package exceptions;

public class EEntradaInvalida extends Exception {

    protected String mensagem;

    public EEntradaInvalida(String mensagem) {
        this.mensagem = mensagem;
    }

}
