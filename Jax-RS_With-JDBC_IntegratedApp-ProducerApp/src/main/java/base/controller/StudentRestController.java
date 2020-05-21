package base.controller;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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

	@GET
	@Produces("application/json")
	public Response getAllStudents() {
		Response resp=null;
		try {
			List<Student> list=service.getAllStudents();
			resp=Response.status(200).entity(list).build();

		} catch (Exception e) {
			resp=Response.status(500).entity("Unable to fetch data !!").build();
			e.printStackTrace();
		}

		return resp;
	}
	@DELETE
	@Path("/{id}")
	public Response deleteOneStudent(
			@PathParam("id")Integer id
			) {
		Response resp=null;
		try {
			boolean status=service.removeOneStudent(id);
			if(status)
				resp=Response.status(200).entity("***** STUDENT "+id+" DELETED *****").build();
			else
				resp=Response.status(Status.BAD_REQUEST).entity("***** STUDENT "+id+" NOT EXIST *****").build();
		} catch (Exception e) {
			resp=Response.status(Status.INTERNAL_SERVER_ERROR).entity("***** UNABLE TO DELETE DATA! *****").build();
			e.printStackTrace();
		}
		return resp;
	}
	@GET
	@Path("/{id}")
	@Produces("application/json")
	public Response getOneStudent(
			@PathParam("id")Integer id
			) {
		Student s=null;
		Response resp=null;
		try {
			s=service.getOneStudent(id);
			if(s!=null)
				resp=Response.status(200).entity(s).build();
			else
				resp=Response.status(Status.NO_CONTENT).build();
		} catch (Exception e) {
			resp=Response.status(Status.INTERNAL_SERVER_ERROR).entity("UNABLE TO FETCH !!").build();
			e.printStackTrace();
		}
		return resp;
	}
	
	@Consumes("application/json")
	@Produces("text/plain")
	@PUT
	public Response updateStudent(Student s) {
		boolean status=service.updateStudent(s);
		Response resp=null;
		try {
			if(status)
				resp=Response
//				.status(Status.RESET_CONTENT)
				.status(Status.OK)
				.entity("UPDATED STUDENT !")
				.build();
			else
				resp=Response.status(Status.NOT_FOUND).entity("STUDENT NOT FOUND !").build();
			
		} catch (Exception e) {
			resp=Response.status(Status.INTERNAL_SERVER_ERROR).entity("UNABLE TO UPDATE!").build();
			e.printStackTrace();
		}
		return resp;
	}
}
