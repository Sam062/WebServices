package base;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

@Path("/emp")
public class EmpRestContoller {
	/*
	 * FOR DEFAULT VALUES WITH QUERY PARAM
	 * 
	 * @GET 
	 * public String showMsg(
	 * 
	 * @DefaultValue("0000")@QueryParam("eid") String eid,
	 * 
	 * @DefaultValue("DEMO NAME")@QueryParam("ename") String ename,
	 * 
	 * @DefaultValue("00.00")@QueryParam("esal") String esal ) { String msg=new
	 * StringBuffer().append("Values are :").append(eid).append(ename).append(esal).
	 * toString(); return msg; }
	 */

	// FOR DEFAULT VALUE WITH MIXED PARAM
	@GET
	@Path("/{esal}")
	public String showM(
			@DefaultValue("101")@QueryParam("eid")Integer eid,
			@DefaultValue("NONAME")@HeaderParam("ename")String ename,
			@DefaultValue("111.1")@PathParam("esal")String esal
			) {
		String msg=new StringBuffer().append("Values :").append(eid).append(ename).append(esal).toString();
		return msg;
	}
}
