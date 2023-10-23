package service;

import model.Recurso;
import model.Usuario;

public class RegraAtiva extends RegraAutentificacao {

    @Override
    public String processar(Usuario usuario, String senha, Recurso recurso) {
        if (!recurso.isAtivo()) {
            return "Recurso " + recurso.getNome() + " inativo";
        }
        if (proximo != null) {
            return proximo.processar(usuario, senha, recurso);
        }
        return "Acesso concedido ao recurso " + recurso.getNome();
    }
}
