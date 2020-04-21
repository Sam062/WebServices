package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/emp")
public class EmployeeRestController {
	@GET
	public String showMsg() {
		return "Employee show msg";
	}
}
