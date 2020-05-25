package base.security;

import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;

public class SecurityFilter implements ContainerRequestFilter {
	@Context
	private HttpHeaders header;
	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		List<String> list=header.getRequestHeader("Authorization");
		
		if(list==null || list.isEmpty()) {
			requestContext.abortWith(Response
					.status(Status.BAD_REQUEST)
					.entity("PLZ PROVIDE BOTH UN AND PWD")
					.build());
			return;
		}
		String auth=list.get(0);
		auth=auth.replaceAll("Basic ","");

		byte[] bytes=Base64.decodeBase64(auth.getBytes());
		String decoded=new String(bytes);

		StringTokenizer token=new StringTokenizer(decoded,":");
		String un=token.nextToken();
		String pwd=token.nextToken();

		if(!("SAM").equalsIgnoreCase(un) && "root".equalsIgnoreCase(pwd)) {
			requestContext.abortWith(Response
					.status(Status.UNAUTHORIZED)
					.entity("PLZ PROVIDE *VAILD* UN AND PWD")
					.build());
			return;
		}
		//ELSE CONTINUE TO REST CONTROLLER....
	}
}
