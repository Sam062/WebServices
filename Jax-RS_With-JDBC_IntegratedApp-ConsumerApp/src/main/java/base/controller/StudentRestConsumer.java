package base.controller;

import java.util.List;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;


import base.Student;

public class StudentRestConsumer {
	public static final String URI="http://localhost:2019/Jax-RS_With-JDBC_IntegratedApp-ProducerApp";
	public static String saveStudent(Student s) {
		String path="/rest/student";
		String msg=null;
		try {
			WebTarget wt=ClientBuilder.newClient().target(URI).path(path);
			Invocation.Builder ib=wt.request();

			Response resp=ib.post(Entity.json(s));
			System.out.println(resp.getStatus());
			msg=resp.readEntity(String.class);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg+" "+s.getSname();
	}
	public static List<Student> getAllStudents() {
		String path="/rest/student";
		List<Student> list=null;
		try {
			WebTarget wt=ClientBuilder.newClient().target(URI).path(path);
			Invocation.Builder ib=wt.request();
			Response resp=ib.get();

			//JSON[{},{}]- List<Student>
			list=resp.readEntity(new GenericType<List<Student>>(){});
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public static String delStudent(int sid) {
		String path="/rest/student/"+sid;
		String msg=null;
		try {
			WebTarget wt=ClientBuilder.newClient().target(URI).path(path);
			Invocation.Builder ib=wt.request();
			Response resp=ib.delete();

			System.out.println(resp.getStatus());
			msg=resp.readEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
	public static Student getOneStudent(int sid) {
		String path="/rest/student/"+sid;
		Student std=null;
		try {
			WebTarget wt=ClientBuilder.newClient().target(URI).path(path);
			Invocation.Builder ib=wt.request();
			Response resp=ib.get();

			std=resp.readEntity(Student.class);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return std;
	}
	public static String updateStudent(Student s) {
		String path="/rest/student";
		String msg=null;
		try {
			WebTarget wt=ClientBuilder.newClient().target(URI).path(path);
			Invocation.Builder ib=wt.request();
			Response resp=ib.put(Entity.json(s));
			msg=resp.readEntity(String.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}
}
