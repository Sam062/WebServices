package base.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import base.model.User;

public class HibernateUtil {
	private static SessionFactory sf=null;
	static {
		Properties p=new Properties();
		p.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
		p.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:ORCL");
		p.put(Environment.USER, "systema");
		p.put(Environment.PASS, "root");
		p.put(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
		p.put(Environment.SHOW_SQL, "true");
		p.put(Environment.HBM2DDL_AUTO, "update");

		Configuration cfg=new Configuration();
		cfg.setProperties(p);
		cfg.addAnnotatedClass(User.class);

		StandardServiceRegistry reg=new 
				StandardServiceRegistryBuilder()
				.applySettings(cfg.getProperties())
				.build();
		sf=cfg.buildSessionFactory(reg);
	}
	public static SessionFactory getSf() {
		return sf;
	}
}
