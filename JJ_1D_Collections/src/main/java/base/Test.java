package base;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {
	public static void main(String[] args) {
		try {
			Student s=new Student();
			s.setSid(101);
			s.setSname("ABC");
			s.setSfee(25.50);
			
			//JDK1.2 :- List<Integer> list=Arrays.asList(10,20,30,40);
			
			/*
			JDK1.7 :- Type Inference for Collection (Empty Diamond Operator at Right side)
			List<Integer> list=new ArrayList<>();
			list.add()....
			*/
			
			//JDK1.9 :-Factory COllection for Immutable Collection
			List<Integer> list=List.of(10,20,30,40);
			s.setMarks(list);
			
			Set<String> set=Set.of("ENG","MATH","HINDI");
			s.setSub(set);
			
			//String[] grades=new String[] {"A+","O","B","B+"};
			s.setGrades(new String[] {"A+","O","B","B+"});
			
			ObjectMapper om=new ObjectMapper();
			String json=om.writeValueAsString(s);
			System.out.println(json);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
