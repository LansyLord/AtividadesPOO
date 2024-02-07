package excecoes.produto;

public class NaoHaProdutosException extends Exception{
    public NaoHaProdutosException(){
        super();
    }

    public NaoHaProdutosException(String mensagem){
        super(mensagem);
    }
}
