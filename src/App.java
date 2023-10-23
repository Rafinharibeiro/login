import model.Recurso;
import model.Usuario;
import service.AutenticacaoService;

public class App {
    public static void main(String[] args) throws Exception {
        runTest();
    }

    private static void runTest() {

        var usuario = new Usuario()
                .id(1)
                .nome("João")
                .email("joao@gmail.com")
                .senha("123")
                .perfil("usuario");

        var adm = new Usuario()
                .id(2)
                .nome("Maria")
                .email("maria@gmail.com")
                .senha("456")
                .perfil("adm");

        var cadastro = new Recurso()
                .nome("Cadastrar usuário")
                .perfilNecessario("usuario")
                .ativo(true);

        var consulta = new Recurso()
                .nome("Consultar usuário")
                .perfilNecessario("usuario")
                .ativo(true);

        var excluir = new Recurso()
                .nome("Excluir usuário")
                .perfilNecessario("adm")
                .ativo(false);

        var login = new Recurso()
                .nome("Logar")
                .perfilNecessario("usuario")
                .ativo(false);

        var service = new AutenticacaoService();

        test(service, usuario, "123", cadastro, "Acesso negado ao recurso Cadastrar usuário");
        test(service, usuario, "123", consulta, "Acesso concedido ao recurso Consultar usuário");
        test(service, usuario, "123", excluir, "Acesso negado ao recurso Excluir usuário");
        test(service, usuario, "123", login, "Recurso Logar inativo");
        test(service, usuario, "456", cadastro, "Senha inválida");
        test(service, usuario, "456", consulta, "Senha inválida");
        test(service, usuario, "456", excluir, "Senha inválida");
        test(service, usuario, "456", login, "Senha inválida");
        test(service, adm, "123", cadastro, "Senha inválida");
        test(service, adm, "123", consulta, "Senha inválida");
        test(service, adm, "123", excluir, "Senha inválida");
        test(service, adm, "123", login, "Senha inválida");
        test(service, adm, "456", cadastro, "Acesso concedido ao recurso Cadastrar usuário");
        test(service, adm, "456", consulta, "Acesso negado ao recurso Consultar usuário");
        test(service, adm, "456", excluir, "Recurso Excluir usuário inativo");
        test(service, adm, "456", login, "Acesso negado ao recurso Logar");

    }

    private static void test(AutenticacaoService service, Usuario usuario, String senha, Recurso recurso,
            String resultadoEsperado) {
        var resultado = service.autenticar(usuario, senha, recurso);
        if (resultado.equals(resultadoEsperado)) {
            System.out.println(
                    String.format("V %s, %s, %s, %s", usuario.getPerfil(), senha, recurso.getNome(), resultado));
            return;
        }
        System.err.println(String.format("X %s, %s, %s, %s", usuario.getPerfil(), senha, recurso.getNome(), resultado));
    }

}
