package weldTest.weldJsfJee.model;

import java.io.Serializable;

import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * JPA-Entity<br>
 * 
 * Dank Model-Stereotype (und dem darin definierten @Named) kann auf Person via
 * #{person} zugegriffen werden. Muss Serializable implementieren, um als
 * CDI-Komponente injected werden zu koennen
 * 
 * @author schuetz
 * @date 18.12.2009
 */
@Model
@Entity
public class Person implements Serializable {

	private Long id;
	private String name;
	private String age;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotNull
	@NotEmpty
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@NotEmpty
	@Digits(fraction = 0, integer = 2)
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
		sb.append(" | ");
		sb.append(name);
		sb.append(" | ");
		sb.append(age);

		return sb.toString();
	}

}
