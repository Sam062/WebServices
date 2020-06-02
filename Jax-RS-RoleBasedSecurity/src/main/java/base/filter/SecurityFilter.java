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

import base.validator.DBValidater;

public class SecurityFilter implements ContainerRequestFilter {
	@Context
	private ResourceInfo info;
	@Context
	private HttpHeaders header; 

	@Override
	public void filter(ContainerRequestContext req) throws IOException {
		//Reflection API------------------------------
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
			if(!(DBValidater.validateUser(un, pwd))) {
				req.abortWith(Response.status(Status.UNAUTHORIZED).entity("---- INVAID SECURITY DETAILS ----").build());
				return;
			}
			else {
				String[] roles=method.getAnnotation(RolesAllowed.class).value();
				List<String> methodRole=Arrays.asList(roles);
				System.out.println("METHOD ROLES : -------------------------"+methodRole); 

				String userRole=DBValidater.getUserRole(un, pwd);

				if(!(methodRole.contains(userRole)))
					req.abortWith(Response.status(Status.FORBIDDEN).entity("--- ROLE FORBIDDEN TO ACCESS THIS SERVICE ---").build());
			}
		}
	}
}
