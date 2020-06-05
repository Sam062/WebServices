package base.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import base.secFilter.MySecurityFilter;

@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig{
	public AppConfig() {
		packages("base");
		register(MySecurityFilter.class);
	}

}
