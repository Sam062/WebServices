package base;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerTest {
	public static void main(String[] args) {
		String URI="http://localhost:2019/Jersry-CP-QueryParam-ProducerApp";
		String path="/rest/emp";
		try {
			Client client=ClientBuilder.newClient();
			WebTarget wt=client.target(URI).path(path);
			
			wt=wt.queryParam("eid", 111);
			wt=wt.queryParam("ename", "XXXZZZ");
			wt=wt.queryParam("esal", 111.111);
			
			Invocation.Builder ib=wt.request();
			Response resp=ib.get();
			
			System.out.println(resp.getStatus()+"-"+resp.getStatusInfo()+"\n"+resp.readEntity(String.class));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
