package incubator.weldJsfJee.identity;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Stores user login and password.
 * 
 * @author schuetz
 * @date 13.01.2010
 */
@RequestScoped
@Named
public class Credentials implements Serializable {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}