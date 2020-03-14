package base;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) {
		try {
			Model m=new Model();
			m.setMid(101);
			m.setMcode("XYZ");
			
			Product p=new Product();
			p.setPid(999);
			p.setPname("AAA");
			p.setMob(m);
			
			ObjectMapper om=new ObjectMapper();
			String json=om.writeValueAsString(p);
			System.out.println(json);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
