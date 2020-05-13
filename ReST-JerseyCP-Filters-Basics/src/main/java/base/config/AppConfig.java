package base.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import base.MyReqFilter;
import base.MyRespFilter;

@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {
	public AppConfig() {
		this.packages("base");

		register(MyReqFilter.class);
		register(MyRespFilter.class);
	}
}
