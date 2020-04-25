package base;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

public class Test {
	public static void main(String[] args) {
		String uri="http://localhost:2019/Jersey-CP-HeaderParam-ProducerApp";
		String path="/rest/emp/val";
		try {
			Invocation.Builder ib=ClientBuilder.newClient().target(uri).path(path).request();

			Response resp=ib.header("clientId", "systema").header("secret", "root").get();
			//			Response resp=ib.header("clientId", "idsss").header("secret", "passwoed").get();
			//			Response resp=ib.header("", "").header("", "").get();

			System.out.println(resp.getStatus()+"-"+resp.getStatusInfo());
			System.out.println(resp.readEntity(String.class));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
