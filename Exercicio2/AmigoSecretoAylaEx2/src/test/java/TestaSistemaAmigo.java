import excecoes.amigo.AmigoInexistenteException;
import excecoes.amigo.AmigoJaExisteException;
import excecoes.amigo.AmigoNaoSorteadoException;

import javax.swing.*;
import java.util.List;

public class TestaSistemaAmigo {
    public static void main(String[] args) {
        Amigo jose = new Amigo("José", "jose@gmail.com", null);
        Amigo maria = new Amigo("Maria", "maria@gmail.com", null);

        SistemaAmigo sistema = new SistemaAmigo();
        try{
            sistema.cadastraAmigo(jose.getNome(), jose.getEmail());
            sistema.cadastraAmigo(maria.getNome(), maria.getEmail());
        }catch(AmigoJaExisteException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }


        try{
            sistema.configuraAmigoSecretoDe("jose@gmail.com","maria@gmail.com");
        }catch(AmigoInexistenteException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        sistema.enviarMensagemParaAlguem("Oi José qual presente você gostaria de ganhar?",
                maria.getEmail(), jose.getEmail(), true);

        sistema.enviarMensagemParaTodos("Gente eu tirei o José", maria.getEmail(), true);

        List<Mensagem> msgAnonimas = sistema.pesquisaMensagensAnonimas();
        for(Mensagem m: msgAnonimas){
            System.out.println(m.getTextoCompletoAoExibir());
        }

        try {
            sistema.pesquisaAmigoSecretoDe(jose.getEmail());
            System.out.println("Ok");
        }catch (AmigoInexistenteException | AmigoNaoSorteadoException e){
            System.out.println(e.getMessage());
        }

    }
}
