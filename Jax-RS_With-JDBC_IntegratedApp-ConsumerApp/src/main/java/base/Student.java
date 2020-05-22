package base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Student {
	@NonNull
	private Integer sid;
	@NonNull
	private String sname;
	@NonNull
	private String scourse;
	@NonNull
	private Double sfee;
	private Double sdiscount;
}
