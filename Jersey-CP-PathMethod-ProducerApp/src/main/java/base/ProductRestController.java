package base;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/prod")
public class ProductRestController {
	@GET
	public String showMsg() {
		return "PROD-GET A";
	}
	@GET
	@Path("/b")
	public String showMsgA() {
		return "PROD-GET PathB";
	}
	@POST
	public String showMsgB() {
		return "PROD-POST A";
	}
	@POST
	@Path("/d")
	public String showMsgC() {
		return "PROD-POST PathB";
	}
}
