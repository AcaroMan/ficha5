package models;

public class Evento {
    private Crianca crianca;
    private Data data;
    private String evento;
    private String notas;

    public Evento(Crianca crianca,Data data,String evento,String notas) {
        this.crianca = crianca;
        this.data=data;
        this.evento = evento;
        this.notas = notas;
    }

    public Crianca getCrianca() {
        return crianca;
    }

    @Override
    public String toString() {
        return evento;
    }
}
