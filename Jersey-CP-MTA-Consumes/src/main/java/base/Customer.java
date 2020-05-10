package base;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	private Integer custId;
	private String custName;
	private Map<String, Double> items;
	private Map<String, Integer> cart;
	private List<Integer> discount;
}
