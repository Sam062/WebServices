package base;

import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;

@Path("/emp")
public class EmployeeRestController {

	@POST
	@Path("/form")
	public String getMsg(
			@FormParam("eid")String eid,
			@FormParam("ename")String ename,
			@FormParam("esal")Double esal
			) 
	{		
		return "FORM Value is : "+eid+"-"+ename+"-"+esal+"".toString();
	}

}
