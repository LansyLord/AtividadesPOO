package excecoes.amigo;

public class AmigoJaExisteException extends Exception{
    public AmigoJaExisteException(){
        super();
    }

    public AmigoJaExisteException(String msg){
        super(msg);
    }
}
