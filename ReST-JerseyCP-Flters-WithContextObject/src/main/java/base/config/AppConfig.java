package base.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import others.MyReqFilter;


@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig{

	public AppConfig() {
		this.packages("others");
		register(MyReqFilter.class);
	}
}
