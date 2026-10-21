package dao;

import java.util.ArrayList;
import modelo.Usuario;

public class UsuarioDao {

    private ArrayList<Usuario> usuarios = new ArrayList<>();

    public UsuarioDao() {

        usuarios.add(new Usuario("admin", "1234"));
    }

    public boolean autenticar(String usuario, String senha) {

        for (Usuario u : usuarios) {

            if (u.getUsuario().equals(usuario)
                    && u.getSenha().equals(senha)) {

                return true;
            }
        }

        return false;
    }
}