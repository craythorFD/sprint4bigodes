package br.com.fiap.sprint4bigodes;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.fiap.sprint4bigodes.model.Bicicleta;
import br.com.fiap.sprint4bigodes.service.BicicletaService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/bicicletas")
public class BicicletaResource {

    private final BicicletaService bicicletaService = new BicicletaService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Bicicleta> listarBicicletas() {
        return bicicletaService.listarBicicletas();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Bicicleta consultarBicicleta(@PathParam("id") Long id) {
        return bicicletaService.consultarBicicleta(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response cadastrarBicicleta(Bicicleta bicicleta) {
        bicicletaService.cadastrarBicicleta(bicicleta);
        return Response.status(Response.Status.CREATED).build();
    }

}
