package base;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement(name = "emp-data")
@XmlAccessorType(XmlAccessType.FIELD)
public class Employee {
	@XmlAttribute(name = "emp-Id")
	private Integer empId;
	@XmlElement(name = "emp-Name")
	private String empName;
	@XmlElement(name = "emp-Sal")
	private Double empSal;
}
