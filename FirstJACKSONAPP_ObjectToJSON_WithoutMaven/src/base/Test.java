package base;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Test {
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		Employee emp=new Employee();
		emp.setEmpId(101);
		emp.setEmpName("SAM");
		emp.setEmpSal(123.05);
		
		ObjectMapper om=new ObjectMapper();
		String json=om.writeValueAsString(emp);
		System.out.println(json);
		
	}

}
