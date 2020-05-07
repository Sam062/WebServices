package base;

import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/emp")
public class EmpRestController {
	@GET
	@Path("/create")
	public Response createCookie() {

		NewCookie c1=new NewCookie("lang","HINDI");
		NewCookie c2=new NewCookie("loc","IND", null, null,"SAMPLE", 600, false);
		Response resp=Response
				.status(Status.OK)
				.entity("Cookie Created !")
				.cookie(c1,c2)
				.build();

		return resp;
	}
	
	
	@GET
	@Path("/read")
	public String read(
				@CookieParam("lang")String lng,
				@CookieParam("loc")String loc
			) {
		return "Values are : LANG is "+lng+" LOC is "+loc;
	}
}
