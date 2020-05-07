package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/emp")
public class EmpRestController {

	//	@GET
	//	@Path("/data/code")
	//	public String showA() {
	//		return "FROM STATIC showA()";
	//	}


	@GET
	@Path("/data/{eid}/{ename}/{esal}")
	public String showB(
			@PathParam("eid")Integer eid,
			@PathParam("ename")String ename,
			@PathParam("esal")Double esal
			) {
		String m="DYNAMIC showB() "+eid+"-"+ename+"-"+esal;
		System.out.println(m);
		return m;
	}
}
