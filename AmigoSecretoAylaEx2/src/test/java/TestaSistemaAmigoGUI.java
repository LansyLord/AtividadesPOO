import excecoes.amigo.AmigoInexistenteException;

import javax.swing.*;

public class TestaSistemaAmigoGUI {
    public static void main(String[] args) {
        SistemaAmigo sistema = new SistemaAmigo();

        int qtAmigos = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantos amigos participarão da brincadeira?"));
        while(qtAmigos % 2 != 0){
            JOptionPane.showMessageDialog(null,"A quantidade de amigos deve ser par, insira novamente!");
            qtAmigos = Integer.parseInt(JOptionPane.showInputDialog(null,"Quantos amigos participarão da brincadeira?"));
        }

        for(int i = 0; i<qtAmigos; i++){
            String nome = JOptionPane.showInputDialog(null, "Insira o nome do "+ (i+1) + "° amigo");
            String email = JOptionPane.showInputDialog(null, "Insira o email do "+ (i+1) + "° amigo");

            sistema.cadastraAmigos(nome, email);
        }

        for(Amigo a: sistema.getAmigos()){
            int index = sistema.getAmigos().indexOf(a);
            int posicaoDaListaSorteada;

            do {
                posicaoDaListaSorteada = (int)(Math.random() * sistema.getAmigos().size());
            } while (posicaoDaListaSorteada == index);

            try{
                sistema.configuraAmigoSecretoDe(a.getEmail(), sistema.getAmigos().get(posicaoDaListaSorteada).getEmail());
            }catch(AmigoInexistenteException e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
            System.out.println(a);
        }

        String texto = JOptionPane.showInputDialog(null, "Digite a mensagem a ser enviada.");
        String emailRemetente = JOptionPane.showInputDialog(null, "Digite de o email de quem a mensagem vai ser enviada.");
        boolean anonima = false;
        String anm = JOptionPane.showInputDialog(null, "A mensagem será anônima?(s/n)");
        if(anm.equalsIgnoreCase("s")) anonima = true;

        sistema.enviarMensagemParaTodos(texto, emailRemetente, anonima);
        for(Mensagem m: sistema.pesquisaTodasAsMensagens()){
            System.out.println(m.getTextoCompletoAoExibir());
        }
    }
}
