import br.ufpb.dcx.poo.quiz.Pergunta;
import br.ufpb.dcx.poo.quiz.PerguntaVF;


import java.util.Scanner;

public class TestaPerguntaVF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String afirmativa = "Fallen já ganhou um Campeonato mundial?";
        String resposta = "Verdadeiro";
        Pergunta pergunta = new PerguntaVF(afirmativa, resposta);

        System.out.println(pergunta+"\n");
        System.out.println("Responda com V ou F");
        String respostaCorreta = sc.nextLine();

        if(pergunta.estahCorretaResposta(respostaCorreta)){
            System.out.println("Acertou!");
        }else{
            System.out.println("Errou!");
        }
    }
}
