package base;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class Test {
	public static void main(String[] args) {
		try {
			
			Student s=new Student();
			s.setStdId(101);
			s.setStdName("SAM");
			s.setSubjects(List.of("ENG","MATH","HINDI"));
			
			JAXBContext context=JAXBContext.newInstance(Student.class);
			Marshaller m=context.createMarshaller();
			m.marshal(s, new File("F:/std.xml"));
			
			System.out.println("DONE");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
