package others;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

public class MyReqFilter implements ContainerRequestFilter{
	@Context
	private HttpHeaders headers;;
	
	@Context
	private HttpServletRequest req;
	
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {

		System.out.println("FROM REQ FILTER WITH CONTAINER OBJECT------------");
		System.out.println(req.getRequestURL());
		System.out.println(req.getRequestURI());
		System.out.println(req.getContextPath());
		System.out.println(req.getMethod());
		System.out.println(req.getLocalAddr());
		
		System.out.println(headers.getRequestHeader("cid"));
		System.out.println(headers.getRequestHeader("cname"));
		
		System.out.println("---------END FROM REQ FILER---------------------");
	}
}
