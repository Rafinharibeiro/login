package service;

import model.Recurso;
import model.Usuario;

public class RegraDeSenha extends RegraAutentificacao {

    @Override
    public String processar(Usuario usuario, String senha, Recurso recurso) {
        if (!usuario.getSenha().equals(senha)) {
            return "Senha inválida";
        }
        if (proximo != null) {
            return proximo.processar(usuario, senha, recurso);
        }
        return "Acesso concedido ao recurso " + recurso.getNome();
    }
}
