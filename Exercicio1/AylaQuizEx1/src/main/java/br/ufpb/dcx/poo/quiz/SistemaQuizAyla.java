package br.ufpb.dcx.poo.quiz;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class SistemaQuizAyla implements SistemaQuiz{

    private List<Pergunta> perguntas;

    public SistemaQuizAyla(List<Pergunta> lista){
        this.perguntas = lista;
    }

    public SistemaQuizAyla(){
        this(new LinkedList<>());
    }

    @Override
    public void cadastraPergunta(Pergunta p){
        if(this.perguntas.size() == 0){
            this.perguntas.add(p);
        }else{
            for(Pergunta pergunta: this.perguntas){
                if(p.equals(pergunta)){
                    return;
                }
            }
            this.perguntas.add(p);
        }
    }

    @Override
    public Pergunta sorteiaPergunta(){
       if(!this.perguntas.isEmpty()){
           return this.perguntas.get(0);
       }
        Random random = new Random();
        return this.perguntas.get(random.nextInt(this.perguntas.size()) + 1);
    }

    @Override
    public List<Pergunta> getTodasAsPerguntas(){
        return this.perguntas;
    }
}