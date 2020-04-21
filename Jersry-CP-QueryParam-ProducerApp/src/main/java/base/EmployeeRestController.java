package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/emp")
public class EmployeeRestController {

	@GET
	public String readInputs(
			@QueryParam("eid")int id,
			@QueryParam("ename")String name,
			@QueryParam("esal")Double sal
			) 
	{
		return "Input Data is : ID="+id+", NAME="+name+", SAL="+sal;
	}

}
