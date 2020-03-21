package base;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) {
		try {
			File file=new File("F:\\WebServices\\Write_JsonToFile\\student.json");
			ObjectMapper om=new ObjectMapper();
			Student std=om.readValue(file, Student.class);
			System.out.println(std);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
