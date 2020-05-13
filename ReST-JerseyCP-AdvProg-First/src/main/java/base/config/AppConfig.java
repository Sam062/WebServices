package base.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("/rest") //URL Pattern
public class AppConfig extends ResourceConfig { //ServletContainer :FC
	public AppConfig() {
		this.packages("in.nit"); //init-param
	}
}
