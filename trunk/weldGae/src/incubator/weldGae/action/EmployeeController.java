package incubator.weldGae.action;

import incubator.weldGae.em.EMF;
import incubator.weldGae.model.Employee;

import java.util.List;
import java.util.Random;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 * CDI-Controller for managing employees.
 * 
 * @author m.schuetz
 * @date 09.02.2010
 */
@Named
public class EmployeeController {
	private EntityManager em = EMF.get().createEntityManager();
	
	 /**
     * @Out behavior: access list via #{employees}.
     */
    @Produces
    @Named
    @RequestScoped
    @SuppressWarnings("unchecked")
    public List<Employee> getEmployees() {
            return em.createQuery("select o from Employee o order by o.firstName")
                            .getResultList();
    }

	//TODO extend with user input
	public void createEmployee(){
		int random  =new Random().nextInt(100);
		
		Employee employee = new Employee();
		employee.setFirstName("FirstName"+random);
		employee.setLastName("LastName"+random);
		
		try {
	       em.persist(employee);
	    } finally {
	        em.close();
	    }
	}
	
}