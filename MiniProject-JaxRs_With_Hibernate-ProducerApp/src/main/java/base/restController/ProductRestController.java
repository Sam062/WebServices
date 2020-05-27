package base.restController;

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

import base.model.Product;
import base.service.IProductService;
@Path("/product")
public class ProductRestController {
	@Inject
	private IProductService service;


	@POST
	@Path("/save")
	@Consumes("application/json")
	public Response insertProduct(Product p) {
		Response resp=null;
		try {
			Integer id=service.saveProduct(p);
			resp=Response.ok("---- Product '"+id+"' saved ----").build();
		} catch (Exception e) {
			resp=Response.status(Status.INTERNAL_SERVER_ERROR).entity("--- UNABLE TO SAVE PRODUCT ---").build();
			e.printStackTrace();
		}
		return resp;
	}
	@PUT
	@Path("/update")
	@Consumes("application/json")
	public Response updateProduct(Product p) {
		Response resp=null;
		try {
			service.updateProduct(p);
			resp=Response.ok("--- Product Details Updated ---").build();

		} catch (Exception e) {
			resp=Response.status(Status.INTERNAL_SERVER_ERROR).entity("--- UNABLE TO UPDATE ---").build();
			e.printStackTrace();
		}
		return resp;
	}
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response getOneProduct(
			@PathParam("id")Integer id
			) {
		Response resp=null;
		try {
			Product product=service.getOneProduct(id);
			if(product!=null)
				resp=Response.status(Status.OK).entity(product).build();
			else
				resp=Response.status(Status.NO_CONTENT).build();
		} catch (Exception e) {
			resp=Response.status(Status.INTERNAL_SERVER_ERROR).entity("--- CAN'T GET DATA ---").build();
			e.printStackTrace();
		}
		return resp;
	}

	@GET
	@Path("/all")
	@Produces("application/json")
	public Response getAllProduct() {
		Response resp=null;
		try {
			List<Product> list=service.getAllProducts();
			resp=Response.status(Status.OK).entity(list).build();
		} catch (Exception e) {
			resp=Response.status(Status.INTERNAL_SERVER_ERROR).entity("--- CAN'T GET DATA ---").build();
			e.printStackTrace();
		}
		return resp;
	}

	@DELETE
	@Path("/{id}")
	public Response deleteProduct(
			@PathParam("id")Integer id
			) {
		Response resp=null;
		try {
			Product p=service.getOneProduct(id);
			if(p!=null) {
				service.deleteProduct(id);
				resp=Response.status(Status.OK).entity("--- DELETED '"+id+"' PRODUCT ---").build();
			}else
				resp=Response.status(Status.NO_CONTENT).build();
		} catch (Exception e) {
			resp=Response.status(Status.INTERNAL_SERVER_ERROR).entity("--- UNABLE TO DELETE ---").build();
			e.printStackTrace();
		}
		return resp;
	}
}
