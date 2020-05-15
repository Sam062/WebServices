package base.controller;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import base.Student;
import base.service.IStudentService;

@Path("/student")
public class StudentRestController {

	@Inject
	private IStudentService service;

	//2. SAVING STUDENT
	@POST
	@Consumes("application/json")
	public Response saveStudent(Student s) {
		Response resp=null;
		try {
			Integer count=service.saveStudent(s);
			if(count>0) {
				resp=Response.status(Status.CREATED).entity("*******STUDENT SAVED *******").build();
			}
			else {
				resp=Response.status(Status.BAD_REQUEST).entity("**** STUDENT NOT ADDED ****").build();
			}
		} catch (Exception e) {
			resp=Response.status(Status.INTERNAL_SERVER_ERROR).entity("**** STUDENT NOT SAVED EXCEPTION!! ****").build();
			e.printStackTrace();
		}
		return resp;
	}
}
