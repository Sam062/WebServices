package base.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertab")
public class User {
	@Id
	@GeneratedValue
	private Integer userId;
	private String userNname;
	private String password;
	private String userRole;
	public User() {
		super();
	}
	public Integer getUserId() {
		return userId;
	}
	public String getUserNname() {
		return userNname;
	}
	public void setUserNname(String userNname) {
		this.userNname = userNname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userNname=" + userNname + ", password=" + password + ", userRole="
				+ userRole + "]";
	}

}
