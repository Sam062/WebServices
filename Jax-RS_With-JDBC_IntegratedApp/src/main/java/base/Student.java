package base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	private Integer sid;
	private String sname;
	private Double sfee;
	private String scourse;
	private Double sdiscount;
}
