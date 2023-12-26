package br.ufpb.dcx.poo.quiz;

public class PerguntaDissertativa extends Pergunta{
    public PerguntaDissertativa(){
        super();
    }

    public PerguntaDissertativa(String enunciado, String respostaCorreta){
        super(enunciado, respostaCorreta);
    }

    @Override
    public boolean estahCorretaResposta(String resposta) {
        return resposta.equalsIgnoreCase(super.getRespostaCorreta());
    }
}
