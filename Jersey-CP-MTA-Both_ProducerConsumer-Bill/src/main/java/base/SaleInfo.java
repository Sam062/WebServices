package base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleInfo {
	private Integer sid;
	private String scode;
	private Double scost;
	private Double discountAmount;
	private Double amount;
	private Double amountAfterDiscount;
}
