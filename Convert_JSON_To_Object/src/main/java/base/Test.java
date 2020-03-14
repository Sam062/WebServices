package base;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) {
		try {
			String json="{\"sid\":101,\"sname\":\"AAA\",\"sfee\":1234.5}";
			
			//Valid JSON Initialized with Def Constructor and Def values
			String json1= "{}";
			
			ObjectMapper om=new ObjectMapper();
			Student s=om.readValue(json, Student.class);
			Student s1=om.readValue(json1, Student.class);
			
			System.out.println(json);
			System.out.println(json1);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
