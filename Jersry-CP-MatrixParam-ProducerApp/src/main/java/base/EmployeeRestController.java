package base;

import javax.ws.rs.GET;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;

@Path("/emp")
public class EmployeeRestController {

	//  .../emp;eid=101;ename=A;esal=3.3
	@GET
	public String show(
			@MatrixParam("eid")int id,
			@MatrixParam("ename")String name,
			@MatrixParam("esal")Double esal
			) {

		return "Input DATA is :"+id+"-"+name+"-"+esal;
	}
}
