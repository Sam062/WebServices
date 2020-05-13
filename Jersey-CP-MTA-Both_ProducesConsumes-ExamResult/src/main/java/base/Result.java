package base;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result {
	private Integer studentId;
	private String studentName;
	private Double totalMarks;
	private Double average;
	private String grade;
	private List<MarksInfoList> marksInfo;
	
	private String finalResult;
}
