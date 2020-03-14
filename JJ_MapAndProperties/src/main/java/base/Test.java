package base;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) {
		try {
			Product p=new Product();
			p.setPid(101);
			p.setPcode("XYZ");
			
			Map<String, String> map=new HashMap<>();
			map.put("m1","RED");
			map.put("m2","BLUE");
			p.setModels(map);
			
			Properties prop=new Properties();
			prop.put("v1", "HELLO");
			prop.put("v2", "BYE");
			p.setInfo(prop);
			
			ObjectMapper om=new ObjectMapper();
			String json=om.writeValueAsString(p);
			System.out.println(json);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
