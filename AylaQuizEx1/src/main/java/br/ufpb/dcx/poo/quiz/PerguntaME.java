package br.ufpb.dcx.poo.quiz;

import java.util.Arrays;
import java.util.Objects;

public class PerguntaME extends Pergunta{
    private String[] alternativas;

    public PerguntaME(String enunciado, String[] alternativas, String respostaCorreta){
        super(enunciado, respostaCorreta);
        this.alternativas = alternativas;
    }

    public PerguntaME(){
        this("", new String[]{}, "");
    }

    @Override
    public boolean estahCorretaResposta(String resposta) {
        return super.getRespostaCorreta().startsWith(resposta);
    }

    public String[] getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(String[] alternativas) {
        this.alternativas = alternativas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerguntaME that = (PerguntaME) o;
        return Arrays.equals(alternativas, that.alternativas) &&
                Objects.equals(super.getEnunciado(), that.getEnunciado()) &&
                Objects.equals(super.getRespostaCorreta(), that.getRespostaCorreta());
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(alternativas)
                +super.getEnunciado().hashCode()
                +super.getRespostaCorreta().hashCode();
    }

    public String toString(){
        String questao = getEnunciado();
        for(String a : this.alternativas){
            questao += "\n" + a;
        }
        return questao;
    }

}