package world.sake.brewery;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/breweries")
public class BreweryController {

    @GET
    @Path("/{breweryName}")
    public Response get(@PathParam String breweryName) {
        System.out.println("get: " + breweryName);

        if (breweryName.equals("未来酒造2")) {
            return Response.ok().entity(BreweryResource.getMockBrewery(breweryName)).build();
        }

        return Response.status(404).build();
    }

    // e.g. http://localhost:8081/breweries/
    @POST
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @Transactional
    public BreweryResource post(BreweryResource brewery) {

        System.out.println("登録します: " + brewery.toString());

        return brewery;
    }
}
