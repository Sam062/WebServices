package base;

import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/emp")
public class EmployeeRestController {

	@GET
	@Path("/data")
	public String readInput(
			@BeanParam Employee empl
			) 
	{
		return empl.toString();
	}

}
