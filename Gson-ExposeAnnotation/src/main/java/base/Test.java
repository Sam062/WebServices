package base;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {
	public static void main(String[] args) {
		try {
			Employee e=new Employee();
			e.setEmpId(101);
			e.setEmpName("SAM");
			e.setEmpSal(123.4);
			e.setPassword("PASSWORD");

			Gson g=new GsonBuilder()
					.excludeFieldsWithoutExposeAnnotation()
					.setPrettyPrinting()
					.create();
			String json=g.toJson(e);
			System.out.println(json);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
