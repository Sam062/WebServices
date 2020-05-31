package base.model;

import lombok.Data;

@Data
public class Product {
	private Integer prodId;
	private String prodName;
	private Double prodCost;

	private Double prodDiscount;
	private Double prodGst;
	private Double totalToPay;
}
