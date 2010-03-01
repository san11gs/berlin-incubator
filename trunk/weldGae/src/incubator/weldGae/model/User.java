package incubator.weldGae.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * JPA User-Entity.
 * 
 * @author schuetz
 * @date 14.01.2010
 */
@Entity
public class User implements Serializable {
	private Long id;
	private String username;
	private String name;
	private String password;

	public User() {
	}

	public User(String username, String name, String password) {
		super();
		this.username = username;
		this.name = name;
		this.password = password;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getDisplayName() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.username);
		sb.append(" (");
		sb.append(this.name);
		sb.append(")");

		return sb.toString();
	}
}
