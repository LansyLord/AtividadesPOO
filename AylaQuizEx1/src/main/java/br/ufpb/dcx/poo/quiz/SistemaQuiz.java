package br.ufpb.dcx.poo.quiz;

import java.util.List;

public interface SistemaQuiz {

    void cadastraPergunta(Pergunta p);
    Pergunta sorteiaPergunta();
    List<Pergunta> getTodasAsPerguntas();
}
