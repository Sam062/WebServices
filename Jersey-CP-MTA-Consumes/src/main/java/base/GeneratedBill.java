package base;

import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement
public class GeneratedBill {
	private String custName;
	private Map<String, Double> listOfItems;
	private Map<String, Integer> cart;
	@XmlElementWrapper(name = "disc")
	private List<Integer> discount;
	private Map<String, Double> finalCart;
	private Double totalCost;
	private String others;
	@Override
	public String toString() {
		return "Customer Name=" + custName + ", \nItems Available=" + listOfItems + ", \nCart=" + cart + ", \nDiscount="
				+ discount + ", \nFinal Cart=" + finalCart + ", \nTotal Cost=" + totalCost + ", \n Others=" + others + "]";
	}
	
}
