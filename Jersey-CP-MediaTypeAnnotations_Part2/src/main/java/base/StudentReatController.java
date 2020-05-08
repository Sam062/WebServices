package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/std")
public class StudentReatController {

	@GET
	@Path("/data")
	@Produces(
			{
				MediaType.APPLICATION_JSON,
				MediaType.APPLICATION_XML
			}
			)
	public Student getStd() {

		Country c=new Country(101,"INDIA",101.1);

		Address a=new Address("JDS", "Jagdishpur", c);

		Student s=new Student(111,"SAM",111.111,a);

		return s;
	}

}
