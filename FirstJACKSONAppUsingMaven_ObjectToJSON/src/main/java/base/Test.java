package base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) throws JsonProcessingException {
		Employee emp=new Employee();
		emp.setEid(101);
		emp.setEname("ABC");
		emp.setEsal(12.555);
		
		ObjectMapper om=new ObjectMapper();
		String json=om.writeValueAsString(emp);
		System.out.println(json);
		
	}

}
