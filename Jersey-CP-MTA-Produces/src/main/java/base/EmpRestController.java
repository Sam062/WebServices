package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/emp")
public class EmpRestController {

	@GET
	@Produces({
		MediaType.APPLICATION_JSON,
		MediaType.APPLICATION_XML
	})
	@Path("/data")
	public Response show(
			@QueryParam("id")Integer id,
			@QueryParam("type")String type,
			@QueryParam("name")String name
			) {
		Response resp=null;
		try {
			if(id==null || id<=0 || name==null || name.trim().isBlank())
				resp=Response.status(400).entity(new ErrorType(400,-1,"Invalid id, plz provide data!!")).build();
			else if(type.equalsIgnoreCase("ADMIN"))
				resp=Response.status(200).entity(new Admin(200,101,name)).build();
			else if(type.equalsIgnoreCase("DEV"))
				resp=Response.status(200).entity(new Developer(200,555,name)).build();
			else
				//type AS NO MATCHED VALUE
				resp=Response.status(Status.BAD_REQUEST)
				.entity(new ErrorType(400,id,type+"- Not found with name"+name)).build();

		} catch (Exception e) {
			//type AS NULL
			resp=Response.status(500).entity(new ErrorType(500,-1,"Invalid Type Specified.")).build();
			e.printStackTrace();
		}
		return resp;
	}
}
