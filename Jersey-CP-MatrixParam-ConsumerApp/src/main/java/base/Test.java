package base;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

public class Test {
	public static void main(String[] args) {
		String uri="http://localhost:2019/Jersry-CP-MatrixParam-ProducerApp";
		String path="/rest/emp";
		try {
			Response resp=ClientBuilder.newClient().target(uri).path(path)
					.matrixParam("eid", 102)
					.matrixParam("ename", "SAM")
					.matrixParam("esal", 99.9)
					.request().get();
			System.out.println(resp.getStatus()+"-"+resp.getStatusInfo());
			System.out.println(resp.readEntity(String.class));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
