package base.secFilter;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

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

import base.util.JWTUtil;
import base.validater.DBValidater;

public class MySecurityFilter implements ContainerRequestFilter{
	@Context
	private HttpHeaders header;

	@Context
	private ResourceInfo recource;

	@Override
	public void filter(ContainerRequestContext req) throws IOException {

		Method method=recource.getResourceMethod();

		if(!method.isAnnotationPresent(PermitAll.class))
		{
			// FOR DenyAll ----------------------------
			if(method.isAnnotationPresent(DenyAll.class)){
				req.abortWith(
						Response
						.status(Status.FORBIDDEN)
						.entity("NOT ALLOWED")
						.build());
			}
			//FOR ROLES ALLOWED ----------------------------------
			else if(method.isAnnotationPresent(RolesAllowed.class)) {
				//IF NO AUTHORIZATION DETAILS --------------------------------
				List<String> authorization=header.getRequestHeader("Authorization");
				if(authorization==null || authorization.isEmpty()){
					req.abortWith(
							Response
							.status(Status.BAD_REQUEST)
							.entity("-- NO AUTHORIZATION DETAILS FOUND --")
							.build());
				}
				// IF AUTHORIZATION DETAILS ARE THERE ------------------------------
				else {
					try {
						String token=authorization.get(0);
						String user=JWTUtil.getSubject(token);
						String userRole=DBValidater.getUserRole(user);
						String[] mRoles=method.getAnnotation(RolesAllowed.class).value();
						List<String> methodRoles=Arrays.asList(mRoles);

						System.out.println("TOKEN-"+token);
						System.out.println("USER-"+user);
						System.out.println("UserRole-"+userRole);
						System.out.println("MethodRole-"+methodRoles);

						// USER ROLE MISMATCH ------------------------------
						if(!methodRoles.contains(userRole))
							req.abortWith(
									Response
									.status(Status.FORBIDDEN)
									.entity("--- USER CAN'T ACCESS THIS METHOD ---")
									.build()
									);
					} catch (Exception e) {
						//IF TOKEN IS NOT VALID OR EXPIRED --------------------------
						req.abortWith(
								Response
								.status(Status.UNAUTHORIZED)
								.entity("--- INVALID TOKEN FOUND ---")
								.build()
								);
						e.printStackTrace();
					}
				}
			}
		}
	}
}

