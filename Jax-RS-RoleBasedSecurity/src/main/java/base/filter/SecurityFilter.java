package base.filter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.codec.binary.Base64;

public class SecurityFilter implements ContainerRequestFilter {
	@Context
	private ResourceInfo info;
	@Context
	private HttpHeaders header; 

	@Override
	public void filter(ContainerRequestContext req) throws IOException {
		Method method=info.getResourceMethod();

		if(method.isAnnotationPresent(DenyAll.class)) {
			req.abortWith(Response.status(Status.FORBIDDEN).entity("** --NOT ALLOWED-- **").build());
		}
		else if(method.isAnnotationPresent(PermitAll.class))
			return;
		else {
			String un=null;
			String pwd=null;
			try {
				List<String> auth=header.getRequestHeader("Authorization");
				String encodedAuth=auth.get(0).replaceAll("Basic ", "");
				byte[] decodedBytes=Base64.decodeBase64(encodedAuth.getBytes());
				String decodedAuth=new String(decodedBytes);

				StringTokenizer token=new StringTokenizer(decodedAuth,":");
				un=token.nextToken();
				pwd=token.nextToken();

			} catch (Exception e) {
				e.printStackTrace();
				req.abortWith(Response.status(Status.UNAUTHORIZED).entity("---- UNABLE TO GET AUTHORIZATION DATA ----").build());
				return;

			}
			if(!(un.equals("systema")&&pwd.equals("root"))) {
				req.abortWith(Response.status(Status.UNAUTHORIZED).entity("---- INVAID SECURITY DETAILS ----").build());
				return;
			}
			else {
				String[] role=method.getAnnotation(RolesAllowed.class).value();
				List<String> roles=Arrays.asList(role);
				System.out.println(roles); 
				String user="CUSTOMER";
				System.out.println(roles.contains(user));// WHY FALSE ?????
				if(!roles.contains(user))
					req.abortWith(Response.status(Status.FORBIDDEN).entity("--- ROLE FORBIDDEN TO ACCESS THIS SERVICE ---").build());
			}
		}
	}
}
