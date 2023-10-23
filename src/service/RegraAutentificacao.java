package service;

import model.Recurso;
import model.Usuario;

public abstract class RegraAutentificacao {
    protected RegraAutentificacao proximo;

    public RegraAutentificacao ou(RegraAutentificacao proximo) {
        this.proximo = proximo;
        return proximo;
    }

    public abstract String processar(Usuario usuario, String senha, Recurso recurso);

}
