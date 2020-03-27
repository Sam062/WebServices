package base;

import java.util.List;
import java.util.Map;

import lombok.Data;

@Data
public class Employee {
	private Integer eid;
	private String ename;
	private Double esal;
	private List<String> list;
	private Map<String, String> map;
	
	private Address addr;
	

}
