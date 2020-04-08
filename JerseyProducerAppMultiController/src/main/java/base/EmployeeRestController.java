package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/emp")
public class EmployeeRestController {
	@GET
	public String getMsg() {
		return "EMPLOYEE REST CONTROLLER";
	}

}
