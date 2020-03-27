package base;

import com.google.gson.annotations.Expose;

import lombok.Data;

@Data
public class Employee {
	@Expose(serialize = false, deserialize = false) //here neither given or taken to json
	//by default both are true
	private Integer empId;
	@Expose
	private String empName;
	@Expose
	private Double empSal;
	//pwd is not taken to the json file
	private String password;

}
