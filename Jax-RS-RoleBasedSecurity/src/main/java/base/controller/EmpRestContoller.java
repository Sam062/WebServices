package base.controller;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/emp")
public class EmpRestContoller {
	@GET
	@Path("/all")
	@PermitAll
	public String showMsgAll() {
		return "FROM PERMIT ALL ANNOTATION **";
	}

	@GET
	@Path("/none")
	@DenyAll
	public String noMsg() {
		return "FROM DENY ALL ANNOTATION **";
	}

	@GET
	@Path("/service")
	@RolesAllowed({"CUSTOMER","EMPLOYEE"})
	public String empService() {
		return "FROM EMPLOYEE SERVICE (RolesAllowed ANNOTATION) **";
	}
	@GET
	@Path("/form")
	@RolesAllowed({"EMPLOYEE","ADMIN"})
	public String empForm() {
		return "FROM EMPLOYEE FORM (RolesAllowed ANNOTATION) **";
	}
}
