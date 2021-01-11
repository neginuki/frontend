package world.sake;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.jaxrs.PathParam;

@Path("/companies/{companyId}/stores")
public class StoreResources {

    /**
     * e.g. http://localhost:8080/companies/1234/stores
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String stores(@PathParam long companyId) {
        System.out.println(companyId);

        return """
                [
                    {
                        "id": 1,
                        "code": "0007",
                        "name": "上野店"
                    },
                    {
                        "id": 2,
                        "code": "1234",
                        "name": "浅草店"
                    },
                    {
                        "id": 3,
                        "code": "9999",
                        "name": "御徒町店"
                    }
                ]
                                                """;
    }
}
