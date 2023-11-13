package br.com.fiap.sprint4bigodes;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.sprint4bigodes.model.Usuario;
import br.com.fiap.sprint4bigodes.service.UsuarioService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/usuarios")
public class UsuarioResource {

    private final UsuarioService usuarioService = new UsuarioService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario consultarUsuario(@PathParam("id") Long id) {
        return usuarioService.consultarUsuario(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario usuario) {
        usuarioService.cadastrarUsuario(usuario);
        return Response.status(Response.Status.CREATED).build();
    }
}