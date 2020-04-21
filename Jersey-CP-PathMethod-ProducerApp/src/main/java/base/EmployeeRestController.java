package base;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/emp")
public class EmployeeRestController {
	
	@GET
	public String showMsg() {
		return "EMP-GET A";
	}
	@GET
	@Path("/b")
	public String showMsgA() {
		return "EMP-GET PathB";
	}
	@POST
	public String showMsgB() {
		return "EMP-POST A";
	}
	@POST
	@Path("/d")
	public String showMsgC() {
		return "EMP-POST PathB";
	}

}
