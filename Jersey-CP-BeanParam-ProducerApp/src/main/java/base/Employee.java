package base;

import javax.ws.rs.QueryParam;

import lombok.Data;

@Data
public class Employee {
	@QueryParam("eid")
	private Integer eid;
	@QueryParam("ename")
	private String ename;
	@QueryParam("esal")
	private Double esal;

}
