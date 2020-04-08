package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/pay")
public class PaymentRestController {
	@GET
	public String getMsg() {
		return "PAYMENT REST CONTROLLER";
	}

}
