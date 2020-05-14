package others;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


public class MyReqFilter implements ContainerRequestFilter{
	@Context
	private HttpHeaders headers;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> h1=headers.getRequestHeader("cid");
		List<String> h2=headers.getRequestHeader("pwd");

		if(h1==null || h1.isEmpty() || h2==null || h2.isEmpty())
		{
			requestContext.abortWith(Response.status(Status.BAD_REQUEST)
					.entity("Plz input both ID & PWD !!")
					.build());
		}else {
			String cid=h1.get(0);
			String pwd=h2.get(0);
			if(!(cid.equalsIgnoreCase("SAM101") && pwd.equalsIgnoreCase("SAM101"))) {
				requestContext.abortWith(Response
						.status(Status.UNAUTHORIZED)
						.entity("Plz input valid ID & PWD !!")
						.build());
			}
		}
	}
}
