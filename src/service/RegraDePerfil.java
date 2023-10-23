package service;

import model.Recurso;
import model.Usuario;

public class RegraDePerfil extends RegraAutentificacao {

    @Override
    public String processar(Usuario usuario, String senha, Recurso recurso) {

        if (!usuario.getPerfil().equals(recurso.getPerfilNecessario())) {
            return "Acesso negado ao recurso " + recurso.getNome();
        }
        if (proximo != null) {
            return proximo.processar(usuario, senha, recurso);
        }
        return "Acesso concedido ao recurso " + recurso.getNome();
    }
}
