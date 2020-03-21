package base;

import com.google.gson.Gson;

public class Test_JsonToObject {
	public static void main(String[] args) {
		try {
			String json="{\r\n" + 
					"  \"eid\": 101,\r\n" + 
					"  \"ename\": \"ABC\",\r\n" + 
					"  \"esal\": 123.4\r\n" + 
					"}\r\n" ;
			
			Gson g=new Gson();
			Employee e=g.fromJson(json, Employee.class);
			System.out.println(e);
					
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
