package base;

import java.io.FileWriter;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Test_ObjectToJsonFile {
	public static void main(String[] args) {

		//JDK 7 auto closable + try with resources
		try(Writer writer=new FileWriter("F:\\WebServices\\Gson-ObjectToJsonFile\\jsonFile"))
		{
			Employee emp=new Employee();
			emp.setEid(125);
			emp.setEname("AA");
			emp.setEsal(25.36);

			Gson g=new GsonBuilder()
					.setPrettyPrinting()
					.create();

			//convert to JSON and store in file
			g.toJson(emp,writer);
			System.out.println("File created");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}