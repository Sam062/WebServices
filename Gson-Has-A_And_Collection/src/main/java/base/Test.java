package base;

import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test {
	public static void main(String[] args) {
		try {
			Address a=new Address();
			a.setHouseNo("123");
			a.setLoc("JDSP");

			Employee e=new Employee();
			e.setEid(101);
			e.setEname("XXX");
			e.setEsal(123.4);
			e.setList(List.of("A","B","C"));
			e.setMap(Map.of("A1","a",
					"A2","b",
					"A3","c")
					);
			e.setAddr(a);

			Gson g=new GsonBuilder().setPrettyPrinting().create();
			String json=g.toJson(e);
			System.out.println(json);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
