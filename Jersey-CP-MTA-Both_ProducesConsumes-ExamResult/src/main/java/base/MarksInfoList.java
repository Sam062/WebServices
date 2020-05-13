package base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MarksInfoList {
	private String subjectName;
	private Integer theoryMark;
	private Integer labMark;
	
	private Double marksPercent; 
	
	private Integer totalMarks;
}
