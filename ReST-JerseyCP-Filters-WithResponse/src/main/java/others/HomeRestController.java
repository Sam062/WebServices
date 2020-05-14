package others;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/home")
public class HomeRestController {
	@GET
	public Response show() {
		return Response.ok("WELCOME TO HOME PAGE").build();
	}
}
