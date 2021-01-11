package world.sake.brewery;

import javax.transaction.Transactional;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/breweries")
public class BreweryController {

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
