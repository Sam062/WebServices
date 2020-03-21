package base;

import java.io.FileReader;
import java.io.Reader;

import com.google.gson.Gson;

public class Test_JsonFileToObject {
	public static void main(String[] args) {
		try {
			Reader read=new FileReader("F:\\WebServices\\Gson-JsonFileToObject\\DemoJsonFile.json");
			Gson g=new Gson();
			Employee emp=g.fromJson(read, Employee.class);
			System.out.println(emp);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
