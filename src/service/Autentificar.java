package service;

import model.Recurso;
import model.Usuario;

public abstract class Autentificar {

    protected Usuario usuario;

    protected Recurso recurso;

    public Autentificar(Usuario usuario) {
        this.usuario = usuario;
    }

    public Autentificar(Recurso recurso) {
        this.recurso = recurso;
    }

    public abstract String isAutentificar(Usuario usuario, String senha, Recurso recurso);

}
