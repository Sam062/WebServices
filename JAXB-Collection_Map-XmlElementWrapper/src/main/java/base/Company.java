package base;

import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Company {
	@XmlElement(name = "comp-ID")
	private Integer cid;
	@XmlElement(name = "comp-NAME")
	private String cname;
//	@XmlElementWrapper(name = "Projects")
//	@XmlElement(name = "PROJ")
	private Map<String, String> projects;

}
