package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/msg")
public class MsgRestController {
	@GET
	public String pub() {
		return "FROM MY REST CONTROLLER\n FROM ADV REST APP";
	}
}
