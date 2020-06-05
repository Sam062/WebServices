package base.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "usertab")
public class User {
	@Id
	@GeneratedValue
	private Integer userId;
	private String userName;
	private String Password;
	private String userRole;
}
