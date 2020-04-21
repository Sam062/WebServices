package base;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerTest {
	public static void main(String[] args) {
		String URI="http://localhost:2019/Jersey-CP-QueryParam-GstProducerApp";
		String path="/rest/gst";
		try {
			WebTarget wt=ClientBuilder.newClient().target(URI).path(path);
			wt=wt.queryParam("cost", 200.50);
			wt=wt.queryParam("per", 50);
			
			Invocation.Builder ib=wt.request();
			Response resp=ib.get();
			
			System.out.println(resp.getStatus()+"-"+resp.getStatusInfo());
			System.out.println(resp.readEntity(String.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
