package br.ufpb.dcx.poo.quiz;

public abstract class Pergunta {

    private String enunciado;
    private String respostaCorreta;


    public Pergunta(){
        this("", "");
    }

    public Pergunta(String respostaCorreta){
        this.respostaCorreta = respostaCorreta;
    }

    public Pergunta(String enunciado, String respostaCorreta){
        this.enunciado = enunciado;
        this.respostaCorreta = respostaCorreta;
    }

    public abstract boolean estahCorretaResposta(String resposta);

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = enunciado;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
}