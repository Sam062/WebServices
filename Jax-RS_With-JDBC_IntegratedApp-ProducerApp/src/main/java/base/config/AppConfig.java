package base.config;

import javax.ws.rs.ApplicationPath;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;

import base.dao.IStudentDao;
import base.dao.StudentDaoImpl;
import base.service.IStudentService;
import base.service.StudentServiceImpl;

@ApplicationPath("/rest")
public class AppConfig extends ResourceConfig{
	public AppConfig() {
		packages("base");

		register(new AbstractBinder() {
			@Override
			protected void configure() {
				bind(StudentDaoImpl.class).to(IStudentDao.class);
				bind(StudentServiceImpl.class).to(IStudentService.class);
			}
		});
	}
}
