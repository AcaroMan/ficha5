package models;

public class Crianca {
    private String nome;
    private Data dataNascimento;
    private String localNascimento;

    public Crianca(String nome, Data dataNascimento, String localNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.localNascimento = localNascimento;

    }

    public String getNome() {
        return nome;
    }

    public Data getDataNascimento() {
        return dataNascimento;
    }

    public String getLocalNascimento() {
        return localNascimento;
    }

    @Override
    public String toString() {
        return nome ;
    }
}
