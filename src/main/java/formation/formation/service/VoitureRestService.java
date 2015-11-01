package formation.formation.service;

import formation.domain.Voiture;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;

/**
 * Created by poutsjr on 30/09/2015.
 */
@Path("/voiture")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class VoitureRestService {

    @EJB
    VoitureServiceItf service;

    @GET
    @Path("/count")
    public Response total() {
        int total = service.total();
        return Response.ok(total).build();
    }

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id")Long id) {
        Voiture v = service.get(id);
        if (v == null) {
            throw new NotFoundException("Voiture is not found");
        }
        return Response.ok(v).build();
    }

    @POST
    public Response create(Voiture voiture) throws Exception {
        Voiture v = service.create(voiture);
        return Response.created(new URI("voiture/" + v.getId())).build();
    }


}
