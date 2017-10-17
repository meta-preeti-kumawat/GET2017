package main.java.com.metacube.layeredArchitecture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements BaseModel {

	@Id
	@Column(name = "user_mail_id")
	private String email;

	@Column(name = "name", nullable = false)
	private String name;

	public User() {
	}

	public User(String email, String name) {
		setEmail(email);
		setName(name);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}