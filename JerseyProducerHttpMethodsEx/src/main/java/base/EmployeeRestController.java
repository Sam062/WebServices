package base;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;

@Path("/emp")
public class EmployeeRestController {
	@GET
	public String fetchEmp() {
		return "FETCH EMP";
	}
	@POST
	public String saveEmp() {
		return "SAVE EMP";
	}
	@PUT
	public String modifyEmp() {
		return "MODIFY EMP";
	}
	@DELETE
	public String removeEmp() {
		return "REMOVE EMP";
	}
}
