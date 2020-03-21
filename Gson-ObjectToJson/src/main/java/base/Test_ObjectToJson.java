package base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test_ObjectToJson {
	public static void main(String[] args) {
		try {
			Employee e=new Employee();
			e.setEid(101);
			e.setEname("ABC");
			e.setEsal(123.4);
			
//			Gson g=new Gson();
//			String json=g.toJson(e);
			
			//or
			//String json=new Gson().toJson(e);
			//or
			
			//to create GsonBuiler Object used new GsonBuilder().create();
			//Gson g=new GsonBuilder().create();
			Gson g=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
			String json=g.toJson(e);
			System.out.println(json);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
