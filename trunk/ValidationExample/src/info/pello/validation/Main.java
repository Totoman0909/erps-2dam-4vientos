/**
 * 
 */
package info.pello.validation;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.*;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.hibernate.validator.*;

/**
 * Simple app to test java Bean validation 
 * @author Pello Altadill
 * @greetz any
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// We create validator instance
		//ValidatorConfiguration config;// = Validation.byProvider( HibernateValidator.class ).configure();
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Customer customer = new Customer();
		Set<ConstraintViolation<Customer>> violations = validator.validate(customer);

		System.out.println("Customer created: " + customer.toString());
		System.out.println("Any constraint violations:");
		if (violations.isEmpty()) {
			System.out.println("Customer seems OK");
		} else {
			System.out.println("Some errors in bean:");
			for (ConstraintViolation<Customer> violation : violations) {
				System.out.println(violation.getMessage());
				System.out.println(violation.toString());
			}
		}
	
	}

}
