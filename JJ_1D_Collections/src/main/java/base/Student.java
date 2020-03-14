package base;

import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Student {
	
	private Integer sid;
	private String sname;
	private Double sfee;
	
	private List<Integer> marks;
	private Set<String> sub;
	private String[] grades;
	

}
