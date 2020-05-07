package base;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class Test {
	public static void main(String[] args) {
		String uri="http://localhost:2019/Jersey-CP-PathParam-ProducerApp";
		String path="/rest/emp/data/10/SAMMMM/1000.1";
		try {
			Response resp=ClientBuilder.newClient()
					.target(uri).path(path)
					.request()
					.get();
			
			System.out.println(resp.getStatus());
			System.out.println(resp.getStatusInfo());
			System.out.println(resp.readEntity(String.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
