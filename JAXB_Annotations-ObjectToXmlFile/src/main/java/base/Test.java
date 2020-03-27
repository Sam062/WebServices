package base;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Test {
	public static void main(String[] args) {
		try {

			Employee e=new Employee();
			e.setEmpIid(101);
			e.setEmpName("ABC");
			e.setEmpSal(123.4);
			e.setPassword("XXXX");

			File fob=new File("F:\\emp.xml");

			JAXBContext jc=JAXBContext.newInstance(Employee.class);
			Marshaller m=jc.createMarshaller();
			m.marshal(e, fob);

			System.out.println("DONE");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
