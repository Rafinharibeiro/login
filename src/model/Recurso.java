package model;

public class Recurso {

    private String nome;
    private String perfilNecessario;
    private boolean ativo = true;

    public Recurso nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Recurso perfilNecessario(String perfilNecessario) {
        this.perfilNecessario = perfilNecessario;
        return this;
    }

    public Recurso ativo(boolean ativo) {
        this.ativo = ativo;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPerfilNecessario() {
        return perfilNecessario;
    }

    public void setPerfilNecessario(String perfilNecessario) {
        this.perfilNecessario = perfilNecessario;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Recurso [nome=" + nome + ", perfilNecessario=" + perfilNecessario + ", ativo=" + ativo + "]";
    }
}
