package base;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
	@XmlElement(name = "std-ID")
	private Integer stdId;
	@XmlElement(name = "std-NAME")
	private String stdName;
	@XmlElementWrapper(name = "ALL-SUB")
	@XmlElement(name = "SUBJ")
	private List<String> subjects;

}
