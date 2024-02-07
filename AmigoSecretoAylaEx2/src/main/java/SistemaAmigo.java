import excecoes.amigo.AmigoInexistenteException;
import excecoes.amigo.AmigoNaoSorteadoException;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {
    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo(List<Mensagem> mensagens, List<Amigo> amigos) {
        this.mensagens = mensagens;
        this.amigos = amigos;
    }

    public SistemaAmigo(List<Amigo> amigos){
        this.mensagens = new ArrayList<>();
        this.amigos = amigos;
    }

    public SistemaAmigo(){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }

    public void cadastraAmigos(String nomeAmigo, String emailAmigo){
        amigos.add(new Amigo(nomeAmigo, emailAmigo, null));
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima){
        Mensagem m = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        mensagens.add(m);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario,
                                         boolean ehAnonima){
        Mensagem m = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        mensagens.add(m);
    }

    public List<Mensagem> pesquisaMensagensAnonimas(){
        List<Mensagem> anonimas = new ArrayList<>();
        for(Mensagem m:mensagens){
            if(m.ehAnonima()) anonimas.add(m);
        }
        return anonimas;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException{
        for(Amigo a:amigos){
            if (a.getEmail().equals(emailDaPessoa)) {
                a.setEmailAmigoSorteado(emailAmigoSorteado);
                return;
            }
        }
        throw new AmigoInexistenteException("O amigo não existe no sistema!");
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return mensagens;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa)throws AmigoInexistenteException, AmigoNaoSorteadoException {
        for(Amigo a: amigos){
            if(a.getEmail().equals(emailDaPessoa)){
                if(a.getEmailAmigoSorteado() == null){
                    throw new AmigoNaoSorteadoException();
                }else{
                    return a.getEmailAmigoSorteado();
                }
            }
        }
        throw new AmigoInexistenteException();
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }
}