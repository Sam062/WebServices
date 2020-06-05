package base.controller;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import base.util.JWTUtil;
import base.validater.DBValidater;

@Path("/user")
public class UserRestContoller {

	@Path("/gen")
	@POST
	@PermitAll
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String checkUserForToken(
			@FormParam("user")String user,
			@FormParam("pwd")String pwd
			) {
		String data=null;
		boolean exist=DBValidater.isUserExist(user, pwd);
		if(exist) {
			data=JWTUtil.generateToken("ID:"+user, user);
		}
		else
			data="INVALID USER '"+user+"' DETAILS";

		return data;
	}

	@Path("/all")
	@GET
	@PermitAll
	public String forAll() {
		return "HELLO FOR ALL";
	}

	@GET
	@Path("/none")
	@DenyAll
	public String forNone() {
		return "NO ONE CAN SEE THIS ";
	}

	@Path("/form")
	@GET
	@RolesAllowed({"EMPLOYEE","USER"})
	public String getForm() {
		return "FROM ROLES ALLOWD TO EMPLOYE/USER";
	}

	@Path("/admin")
	@GET
	@RolesAllowed({"EMPLOYEE","ADMIN"})
	public String getService() {
		return "FROM ROLES ALLOWED TO EMPLOYE/ADMIN";
	}
}
