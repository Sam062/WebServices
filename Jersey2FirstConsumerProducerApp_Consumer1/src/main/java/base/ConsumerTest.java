package base;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;


public class ConsumerTest {
	public static void main(String[] args) {
		String URI="http://localhost:2019/Jersey2FirstConsumerProducerApp";
		String path="/rest/emp";
		try {
			//1. Create Client Object
			Client cl=ClientBuilder.newClient();

			//2. Define WebTarget by adding Target(URI) and Path
			WebTarget wt=cl.target(URI).path(path);

			//3. Convert into Request Object  
			//(Equals to HTTP Request under construction)
			Invocation.Builder ib=wt.request();

			//4. provide HTTP MethodType
			Response resp=ib.get();

			//5. Read and Print Response details
			System.out.println(resp.getStatus()+"--"+resp.getStatusInfo());
			System.out.println(resp.readEntity(String.class));


			/*
			 * To run this app First Run [Jersey2FirstConsumerProducerApp] on server
			 * and then Run this File as Java App
			 */


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
