package excecoes.produto;

public class ProdutoNaoEncontradoException extends Exception{

    public ProdutoNaoEncontradoException(){
        super();
    }

    public ProdutoNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
