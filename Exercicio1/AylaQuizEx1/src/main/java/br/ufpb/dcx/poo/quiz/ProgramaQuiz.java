package br.ufpb.dcx.poo.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ProgramaQuiz {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SistemaQuizAyla quizSys = new SistemaQuizAyla();

        int escolha = -1;
        while(escolha != 3){
            System.out.println("Sistema Criador de Quiz\n");
            System.out.println("1. Criar Perguntas\n"+
                                "2. Responder Perguntas\n"+
                                "3. Sair");

            System.out.println("Insira apenas os números que aparecem no menu\n");
            System.out.print("Selecione a opção:");
            escolha = Integer.parseInt(sc.nextLine());

            if(escolha == 1){
                System.out.println("Qual o tipo de pergunta será criado?\n");
                System.out.println("1. Pergunta de Mútipla escolha\n"+
                        "2. Pergunta Dissertativa\n"+
                        "3. Pergunta Verdadeiro e Falso");
                System.out.println("Insira apenas os números que aparecem no menu\n");
                System.out.print("\nSelecione a opção: ");
                int opcao = Integer.parseInt(sc.nextLine());
                if(opcao == 1){
                    System.out.println("Insira o enunciado:");
                    String enunciado = sc.nextLine();

                    System.out.println("\nInsira as 4 alternativas:");
                    String[] alternativas = new String[4];
                    for(int i = 0; i<4; i++){
                        System.out.println("\nDigite a "+(i+1)+ "a alternativa:");
                        alternativas[i]= sc.nextLine();
                    }
                    System.out.println("\nDigite a Resposta Correta:");
                    String respostaCorreta = sc.nextLine();

                    Pergunta p = new PerguntaME(enunciado, alternativas, respostaCorreta);
                    quizSys.cadastraPergunta(p);
                }

                else if(opcao == 2){
                    System.out.println("\nInsira o enunciado:");
                    String enunciado = sc.nextLine();

                    System.out.println("\nDigite a Resposta Correta:");
                    String respostaCorreta = sc.nextLine();

                    Pergunta p = new PerguntaDissertativa(enunciado, respostaCorreta);
                    quizSys.cadastraPergunta(p);
                }
                else if(opcao == 3){
                    System.out.println("\nDigite a afirmativa:");
                    String afirmativa = sc.nextLine();

                    System.out.println("\nDigite a Resposta Correta:");
                    String respostaCorreta = sc.nextLine();

                    Pergunta p = new PerguntaVF(afirmativa, respostaCorreta);
                    quizSys.cadastraPergunta(p);
                }

                System.out.println("Pergutna cadastrada com sucesso!");
            }else if(escolha == 2){
                List<Pergunta> todasAsPerguntas = new ArrayList<>(quizSys.getTodasAsPerguntas());

                while (!todasAsPerguntas.isEmpty()) {

                    int indiceSorteado = new Random().nextInt(todasAsPerguntas.size());

                    Pergunta perguntaSorteada = todasAsPerguntas.get(indiceSorteado);

                    if (perguntaSorteada instanceof PerguntaME) {
                        System.out.println(perguntaSorteada.toString());
                        System.out.print("\nInsira sua resposta: ");
                        String resposta = sc.nextLine();

                        if (perguntaSorteada.estahCorretaResposta(resposta)) {
                            System.out.println("\nParabéns você acertou!");
                        } else {
                            System.out.println("\nResposta incorreta!");
                        }
                        System.out.println("---------------------------------------");
                    }

                    // Remove a pergunta sorteada da lista para evitar repetições
                    todasAsPerguntas.remove(indiceSorteado);
                }

            }
        }
    }
}
