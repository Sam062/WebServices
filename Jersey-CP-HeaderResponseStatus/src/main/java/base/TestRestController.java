package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/test")
public class TestRestController {

	@GET
	@Path("/val")
	public Response doTest(
			@QueryParam("input")Integer val
			) {
		Response resp=null;
		try {
			if(val==null) {
				resp=Response.status(400)
						.header("RESULT", "NOT EXECUTED")
						.entity("NO INPUT DATA GIVEN")
						.build();
			}
			else {
				int x=100/val;
				resp=Response.status(200)
						.header("RESULT", "EXECUTED")
						.entity("EXECUTED SUCCESSFULLY")
						.build();
			}
		} catch (Exception e) {
			resp=Response.status(500)
					.header("RESULT", "FAIL")
					.entity("UNABLE TO PROCESS")
					.build();
			e.printStackTrace();
		}
		return resp;
	}
}
