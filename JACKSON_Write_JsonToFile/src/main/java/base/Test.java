package base;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) {
		try {
			Student s=new Student();
			s.setSid(101);
			s.setSname("AAA");
			s.setSfee(1234.5);
			
			ObjectMapper om=new ObjectMapper();
			File file=new File("F:\\WebServices\\Write_JsonToFile\\student.json");
			om.writeValue(file, s);
			System.out.println("DONE");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
