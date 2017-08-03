package exceptions;

public class EObjetoJaDefinido extends Exception {

    protected String mensagem;

    public EObjetoJaDefinido(String mensagem) {
        this.mensagem = mensagem;
    }

}
