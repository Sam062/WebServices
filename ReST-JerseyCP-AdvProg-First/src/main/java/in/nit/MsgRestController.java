package in.nit;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/msg")
public class MsgRestController {
	@GET
	public String showMsg() {
		return "HELLO WORLD";
	}
}
