package base;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/test")
public class UserRestContoller {

	@GET
	public String showMsg() {
		return "WELCOME TO CONSUMER";
	}


}
