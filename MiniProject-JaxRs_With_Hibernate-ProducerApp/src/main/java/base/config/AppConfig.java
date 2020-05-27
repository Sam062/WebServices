package base.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import base.dao.IProductDao;
import base.dao.ProductDaoImpl;
import base.service.IProductService;
import base.service.ProductServiceImpl;

@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig {
	public AppConfig() {
		packages("base");
		register(new AbstractBinder() {

			@Override
			protected void configure() {
				bind(ProductDaoImpl.class).to(IProductDao.class);
				bind(ProductServiceImpl.class).to(IProductService.class);
			}
		});
	}
}
