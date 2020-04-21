package base;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class ConsumerTest {
	public static void main(String[] args) {
		String URI="http://localhost:2019/Jersey-CP-PathMethod-ProducerApp";
//		String path="/rest/emp";
//		String path="/rest/emp/b";
		String path="/rest/prod";
		try {
			Client client=ClientBuilder.newClient();
			
			WebTarget webTarget=client.target(URI).path(path);
			
			Invocation.Builder ib=webTarget.request();
			
//			Response resp=ib.get();
			Response resp=ib.post(null);
			
			System.out.println(resp.getStatus()+"-"+resp.getStatusInfo());
			System.out.println(resp.readEntity(String.class));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
