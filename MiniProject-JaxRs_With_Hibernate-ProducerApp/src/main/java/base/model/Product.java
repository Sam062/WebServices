package base.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.Data;

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="prodtab")
public class Product {
	@Id
	@GeneratedValue
	@Column(name="pid")
	private Integer prodId;
	@Column(name="pname")
	private String prodName;
	@Column(name="pcost")
	private Double prodCost;

	@Column(name="pdisc")
	private Double prodDiscount;
	@Column(name="pgst")
	private Double prodGst;
	@Column(name="topay")
	private Double totalToPay;
}
