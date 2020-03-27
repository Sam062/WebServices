package base;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Test {
	public static void main(String[] args) {
		try {
			File file=new File("F:\\emp.xml");
			
			Employee e=new Employee();
			e.setEid(101);
			e.setEname("SAM");
			e.setEsal(123.4);
			
			JAXBContext j=JAXBContext.newInstance(Employee.class);
			Marshaller m=j.createMarshaller();
			m.marshal(e, file);
			
			System.out.println("done");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
