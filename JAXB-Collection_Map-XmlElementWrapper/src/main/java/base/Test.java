package base;

import java.io.File;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Test {
	public static void main(String[] args) {
		try {
			Company c=new Company();
			c.setCid(101);
			c.setCname("DELL");
			c.setProjects(Map.of("p1","AAA","p2","BBB","p3","CCC"));
			
			JAXBContext cont=JAXBContext.newInstance(Company.class);
			Marshaller m=cont.createMarshaller();
			m.marshal(c, new File("F:/comp.xml"));
			
			System.out.println("DONE");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
