package base;

import java.util.Map;
import java.util.Properties;

import lombok.Data;

@Data
public class Product {
	private Integer pid;
	private String pcode;
	
	private Map<String, String> models;
	private Properties info;

}
