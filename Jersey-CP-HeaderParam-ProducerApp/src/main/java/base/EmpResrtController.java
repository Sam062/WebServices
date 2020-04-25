package base;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/emp")
public class EmpResrtController {

	@GET
	@Path("/val")
	public Response validate(
			@HeaderParam("clientId")String id,
			@HeaderParam("secret")String pwd
			) {
		Response resp=null;
		if(id==null || pwd==null || id.isBlank() || pwd.isBlank())
			resp=Response.status(Status.BAD_REQUEST).entity("No Consumer varification Details provided.").build();
		//resp=Response.status(400).entity("No Consumer varification Details provided.").build();
		else if(id.equals("systema")&& pwd.equals("root"))
			resp=Response.status(Status.OK).entity("WELCOME TO CONSUMER SERVICES.").build();
		//resp=Response.status(200).entity("WELCOME TO CONSUMER SERVICES.").build();
		else
			resp=Response.status(Status.UNAUTHORIZED).entity("INVALID DETAILS.").build();
		//resp=Response.status(401).entity("INVALID DETAILS.").build();

		return resp;
	}
}
