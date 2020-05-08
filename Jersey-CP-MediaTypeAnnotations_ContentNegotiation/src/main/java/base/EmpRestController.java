package base;

import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/emp")
public class EmpRestController {

	@GET
	//	@Produces(MediaType.APPLICATION_JSON)  or
	//	@Produces("application/json")
	//	@Produces(MediaType.APPLICATION_XML)  or
	@Produces("application/xml")
	public Student empshow() {
		Student s=new Student();
		s.setSid(101);
		s.setSname("SAM");
		return s;
	}

	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> getStd(){
		List<Student> list=List.of(
				new Student(101,"SAM",new Address("JDSP","Jagdishpur")),
				new Student(102,"HARI",new Address("FZB","Faizabad")),
				new Student(103,"ABC",new Address("LKO","Lucknow"))
				);

		return list;
	}
	@GET
	@Path("/map")
	@Produces(MediaType.APPLICATION_JSON)
	public Map<String, Student> getMap(){
		Map<String, Student> map=Map.of(
				"MCA-101",new Student(101,"SAM",new Address("JDSP","Jagdishpur")),
				"MCA-102",new Student(102,"HARI",new Address("FZB","Faizabad")),
				"MCA-103",new Student(103,"ABC",new Address("LKO","Lucknow"))			
				);
		return map;
	}


	//CONTENT NEGOTIATION*****************************************************
	@GET
	@Path("/mapcontent")
	@Produces(
			{
				MediaType.APPLICATION_JSON,
				MediaType.APPLICATION_XML
			}
			)
	public Student details() {
		Student s=new Student();
		s.setSid(101);
		s.setSname("SAM");
		s.setAddr(new Address("JDSP", "JAGDISHPUR"));
		return s;
	}
}
