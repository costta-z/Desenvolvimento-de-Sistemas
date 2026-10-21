package controle;

import dao.UsuarioDao;

public class UsuarioControle {

    private UsuarioDao dao;

    public UsuarioControle() {

        dao = new UsuarioDao();
    }

    public boolean validarLogin(String usuario, String senha) {

        if (usuario == null || senha == null
                || usuario.trim().isEmpty()
                || senha.isEmpty()) {

            return false;
        }

        return dao.autenticar(usuario.trim(), senha);
    }
}