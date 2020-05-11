package base;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@XmlRootElement
public class Invoice {
	private Integer id;
	private String code;
	private Double totalPrice;
	private Double gstAmount;
	private Double billAmount;
	private List<SaleInfo> saleInfo;
}
