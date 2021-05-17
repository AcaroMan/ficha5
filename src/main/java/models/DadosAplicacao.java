package models;

import java.util.ArrayList;

public enum DadosAplicacao {
    INSTANCE;
    private ArrayList<Crianca> criancas;
    private ArrayList<Evento> eventos;

     DadosAplicacao() {
        criancas = new ArrayList<>();
        eventos = new ArrayList<>();
    }
    public ArrayList<Evento> getEventos(Crianca crianca){
         ArrayList<Evento> match = new ArrayList<>();
        for (Evento evento:eventos) {
            if(evento.getCrianca().equals(crianca)){
                match.add(evento);
            }
        }
        return match;
     }
    public ArrayList<Crianca> getCriancas(){
         return new ArrayList(criancas);
    }

    public boolean existeCriancaComNome(String nome){
        for (Crianca crianca:criancas) {
                if(crianca.getNome().equals(nome)) return true;
            }

        return false;
    }
    public void adicionarCrianca(Crianca crianca){
         if(crianca==null){
             return;
         }
         criancas.add(crianca);
         eventos.add(new Evento(crianca,crianca.getDataNascimento(),"Nascimento de "+crianca.getNome(),""));
    }
}
