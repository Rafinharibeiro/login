package service;

import model.Usuario;
import model.Recurso;

public class AutenticacaoService {

    private RegraAutentificacao regraAutentificacao;

    public AutenticacaoService() {
        regraAutentificacao = new RegraDeSenha()
                .ou(new RegraDePerfil())
                .ou(new RegraAtiva());
    }

    public String autenticar(Usuario usuario, String senha, Recurso recurso) {
        return regraAutentificacao.processar(usuario, senha, recurso);
    }

}

// return "Senha inválida";
// } else if (!usuario.getPerfil().equals(recurso.getPerfilNecessario())) {
// return "Acesso negado ao recurso " + recurso.getNome();
// } else if (!recurso.isAtivo()) {
// return "Recurso " + recurso.getNome() + " inativo";
// } else {
// return "Acesso concedido ao recurso " + recurso.getNome();
// }
