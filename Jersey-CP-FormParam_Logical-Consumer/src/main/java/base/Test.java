package base;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.Response;

public class Test {
	public static void main(String[] args) {
		String uri="http://localhost:2019/Jersey-CP-FormParam_Logical-Producer";
		String path="/rest/emp/form";
		try {
			WebTarget wt=ClientBuilder.newClient().target(uri).path(path);
			Form f=new Form();
			f.param("eid", "111");
			f.param("ename", "SAM");

			Invocation.Builder ib=wt.request();
			Response resp=ib.post(Entity.form(f));

			System.out.println(resp.getStatus());
			System.out.println(resp.getStatusInfo());
			System.out.println(resp.readEntity(String.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
