public class MensagemParaTodos extends Mensagem{
    public MensagemParaTodos(String texto, String emailRemetente, boolean anonima) {
        super(texto, emailRemetente, anonima);
    }

    @Override
    public String getTextoCompletoAoExibir() {
        if (ehAnonima()) {
            return "Texto:\n" + getTexto();
        } else {
            return "Mensagem de: " + getEmailRemetente() + " para " +
                    ".\nTexto:\n" + getTexto();
        }
    }

}
