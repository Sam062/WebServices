package base;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class HibernateUtil {
	private static SessionFactory sf=null;
	static {
		try {
			//	PROPERTIES OBJECT USING ENVIRONMENT
			Properties prop=new Properties();
			prop.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
			prop.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:ORCL");
			prop.put(Environment.USER, "systema");
			prop.put(Environment.PASS, "root");
			prop.put(Environment.DIALECT,"org.hibernate.dialect.OracleDialect");
			prop.put(Environment.SHOW_SQL,"true");
			prop.put(Environment.HBM2DDL_AUTO,"update");

			//	CONVERT INTO HIBERNATE OBJECT FORMAT
			Configuration cfg=new Configuration();
			//	LOAD PROPERTIES INTO CONFIGURATION
			cfg.setProperties(prop);

			//	PROVIDE ENTITY DETAILS TO CFG
			cfg.addAnnotatedClass(Student.class);

			//	SERVICE REGISTRY
			StandardServiceRegistry reg=new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties())
					.build();

			//	SESSION FACTORY
			sf=cfg.buildSessionFactory(reg);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static SessionFactory getSf() {
		return sf;
	}
}
