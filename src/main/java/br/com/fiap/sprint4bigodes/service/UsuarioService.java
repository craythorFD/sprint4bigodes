package br.com.fiap.sprint4bigodes.service;

import java.util.List;

import br.com.fiap.sprint4bigodes.data.UsuarioDao;
import br.com.fiap.sprint4bigodes.model.Usuario;

public class UsuarioService {

    private final UsuarioDao usuarioDAO = new UsuarioDao();

    public void cadastrarUsuario(Usuario usuario) {
        usuarioDAO.cadastrarUsuario(usuario);
    }

    public Usuario consultarUsuario(Long id) {
        return usuarioDAO.consultarUsuario(id);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioDAO.listarUsuarios();
    }

}
