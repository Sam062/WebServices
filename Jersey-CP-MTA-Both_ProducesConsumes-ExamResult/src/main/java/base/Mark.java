package base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mark {
	private String subjectName;
	private Integer theoryMark;
	private Integer labMark;
}
