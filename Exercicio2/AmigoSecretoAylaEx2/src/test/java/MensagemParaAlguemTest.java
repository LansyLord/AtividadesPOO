import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MensagemParaAlguemTest {
    String texto = "Olá como vai seu trabalho em Nova York? Está gostando?";
    String remetente = "felipe.dev26@gmail.com";
    String destinatario = "lansylord@gmail.com";
    Mensagem mensagem = new MensagemParaAlguem(texto, remetente, destinatario, false);
    Mensagem mensagem2 = new MensagemParaAlguem(texto, remetente, destinatario, true);

    @Test
    public void testExibeTextoCompleto(){
        //Mensagem não anônima
        assertEquals("Mensagem de: felipe.dev26@gmail.com para lansylord@gmail.com.\n" +
                "Texto:\nOlá como vai seu trabalho em Nova York? Está gostando?", mensagem.getTextoCompletoAoExibir());

        //Mensagem anônima
        assertEquals("Mensagem para: lansylord@gmail.com.\nTexto:\n" +
                "Olá como vai seu trabalho em Nova York? Está gostando?", mensagem2.getTextoCompletoAoExibir());


        System.out.println(mensagem.getTextoCompletoAoExibir());
        System.out.println("--------------------------------------");
        System.out.println(mensagem2.getTextoCompletoAoExibir());
    }
}
