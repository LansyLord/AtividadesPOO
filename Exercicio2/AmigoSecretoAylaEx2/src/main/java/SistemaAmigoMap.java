import excecoes.amigo.AmigoInexistenteException;
import excecoes.amigo.AmigoJaExisteException;
import excecoes.amigo.AmigoNaoSorteadoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {
    private List<Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap(List<Mensagem> mensagens, Map<String, Amigo> amigos) {
        this.mensagens = mensagens;
        this.amigos = amigos;
    }

    public SistemaAmigoMap(Map<String, Amigo> amigos) {
        this.mensagens = new ArrayList<>();
        this.amigos = amigos;
    }

    public SistemaAmigoMap() {
        this.mensagens = new ArrayList<>();
        this.amigos = new HashMap<>();
    }

    public Amigo pesquisaAmigo(String email) throws AmigoInexistenteException {
        if (amigos.isEmpty()) throw new AmigoInexistenteException("O amigo não existe no sistema!");
        else if (this.amigos.containsKey(email)) {
            return this.amigos.get(email);
        }

        throw new AmigoInexistenteException("O amigo não existe no sistema!");
    }

    public void cadastraAmigo(String nomeAmigo, String emailAmigo) throws AmigoJaExisteException {
        for (Amigo a : this.amigos.values()) {
            if (a.getNome().equalsIgnoreCase(nomeAmigo) && a.getEmail().equalsIgnoreCase(emailAmigo)) {
                throw new AmigoJaExisteException("O amigo já existe no sistema");
            }
        }
        amigos.put(emailAmigo, new Amigo(nomeAmigo, emailAmigo, null));
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean ehAnonima) {
        Mensagem m = new MensagemParaTodos(texto, emailRemetente, ehAnonima);
        mensagens.add(m);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario,
                                         boolean ehAnonima) {
        Mensagem m = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, ehAnonima);
        mensagens.add(m);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> anonimas = new ArrayList<>();
        for (Mensagem m : mensagens) {
            if (m.ehAnonima()) anonimas.add(m);
        }
        return anonimas;
    }

    public void configuraAmigoSecretoDe(String emailDaPessoa, String emailAmigoSorteado) throws AmigoInexistenteException {
        if (this.amigos.containsKey(emailDaPessoa)) {
            this.amigos.get(emailDaPessoa).setEmailAmigoSorteado(emailAmigoSorteado);
        }
        else throw new AmigoInexistenteException("O amigo não existe no sistema!");
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return mensagens;
    }

    public String pesquisaAmigoSecretoDe(String emailDaPessoa) throws AmigoInexistenteException, AmigoNaoSorteadoException {
        if (this.amigos.containsKey(emailDaPessoa)) {
            Amigo a = this.amigos.get(emailDaPessoa);
            if (a.getEmailAmigoSorteado() == null) {
                throw new AmigoNaoSorteadoException();
            } else {
                return a.getEmailAmigoSorteado();
            }
        }

        throw new AmigoInexistenteException();
    }

    public Map<String, Amigo> getAmigos() {
        return amigos;
    }
}