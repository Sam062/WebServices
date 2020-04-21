package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/gst")
public class GstCalculateRestController {

	@GET
	public String finalCost(
			@QueryParam("cost")Double pcost,
			@QueryParam("per")Integer percent
			) {	
		return "Final Cost is ="+((pcost*percent)/100)+pcost;
	}
}
