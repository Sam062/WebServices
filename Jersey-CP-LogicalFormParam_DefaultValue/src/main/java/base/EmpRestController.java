package base;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/emp")
public class EmpRestController {
	//@Consumes for Form param
	@POST
	@Consumes("application/x-www-form-urlencoded")
	public String msg(
			@DefaultValue("11.1")@QueryParam("esal")Double esal,
			@DefaultValue("NoName")@HeaderParam("ename")String ename,
			@DefaultValue("NoDEPT")@FormParam("dept")String dept
			) {
		return "Values : "+ename+"-"+esal+"-"+dept;
	}
}
