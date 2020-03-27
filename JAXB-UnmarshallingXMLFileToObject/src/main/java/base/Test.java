package base;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class Test {
	public static void main(String[] args) {
		try {
			File fob=new File("F:\\emp.xml");

			JAXBContext jc=JAXBContext.newInstance(Employee.class);
			Unmarshaller um=jc.createUnmarshaller();
			Object ob=um.unmarshal(fob);
			if(ob instanceof Employee) {
				Employee emp=(Employee)ob;
				System.out.println(emp);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
