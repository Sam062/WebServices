package base;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class Employee {
	private Integer eid;
	private String ename;
	private Double esal;
}
