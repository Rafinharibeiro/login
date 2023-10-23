package model;

public class Usuario {
    private int id;
    private String nome;
    private String email;
    private String senha;
    private String perfil;

    public Usuario id(int id) {
        this.id = id;
        return this;
    }

    public Usuario nome(String nome) {
        this.nome = nome;
        return this;
    }

    public Usuario email(String email) {
        this.email = email;
        return this;
    }

    public Usuario senha(String senha) {
        this.senha = senha;
        return this;
    }

    public Usuario perfil(String perfil) {
        this.perfil = perfil;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", perfil=" + perfil
                + "]";
    }
}
