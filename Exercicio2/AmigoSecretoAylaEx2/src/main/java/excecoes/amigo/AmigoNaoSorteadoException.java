package excecoes.amigo;

public class AmigoNaoSorteadoException extends Exception{
    public AmigoNaoSorteadoException(){
        super();
    }

    public AmigoNaoSorteadoException(String msg){
        super(msg);
    }
}
