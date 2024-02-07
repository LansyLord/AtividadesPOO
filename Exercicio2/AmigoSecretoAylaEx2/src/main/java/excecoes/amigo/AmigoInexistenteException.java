package excecoes.amigo;

public class AmigoInexistenteException extends Exception{
    public AmigoInexistenteException(){
        super();
    }

    public AmigoInexistenteException(String msg){
        super(msg);
    }
}
