package excecoes.produto;

public class ProdutoJaCadastradoException extends Exception{

    public ProdutoJaCadastradoException(){
        super();
    }

    public ProdutoJaCadastradoException(String mensagem){
        super(mensagem);
    }
}
