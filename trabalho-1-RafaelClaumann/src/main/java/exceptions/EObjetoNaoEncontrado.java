package exceptions;

public class EObjetoNaoEncontrado extends Exception {

    protected String mensagem;

    public EObjetoNaoEncontrado(String mensagem) {
        this.mensagem = mensagem;
    }

}
