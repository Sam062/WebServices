package base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Part {
	private Integer pid;
	private String pcode;
	private Double pcost;
	private Integer quantity;
	private Integer discPercent;
}
