package incubator.needle.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Entity representing customer.
 * 
 * @author m.schuetz
 * @date 26.03.2010
 */
@Entity
public class Customer implements Serializable {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false, unique = true)
	private String customerNumber;

	private String firstName;

	private String lastName;

	public Customer() {
	}

	public Customer(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public Long getId() {
		return id;
	}

	public String getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(String customerNumber) {
		this.customerNumber = customerNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
