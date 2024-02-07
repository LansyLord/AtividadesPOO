package br.ufpb.dcx.poo.quiz;

public class PerguntaVF extends Pergunta{

    private String afirmativa;

    public PerguntaVF(String afirmativa, String respostaCorreta){
        super(respostaCorreta);
        this.afirmativa = afirmativa;
    }

    public PerguntaVF(){
        super();
        this.afirmativa = "";
    }

    public boolean estahCorretaResposta(String resposta){
        return super.getRespostaCorreta().startsWith(resposta);
    }

    public String getAfirmativa() {
        return afirmativa;
    }

    public void setAfirmativa(String afirmativa) {
        this.afirmativa = afirmativa;
    }

    @Override
    public String toString(){
        return this.afirmativa;
    }
}
