package info.pello.maven.hibernate.HibernateSamples;

import java.util.List;

/**
 * Main class
 * @author Pello Xabier Altadill Izura
 * @greetz 4 u
 * @listening "Mouth for war - Pantera"
 *  Revenge 
 *  I'm screaming revenge again 
 *  Wrong 
 *  I've been wrong for far too long 
 *  Been constantly so frustrated 
 *  I've moved mountains with less 
 *  When I channel my hate to productive 
I*  don't find it hard to impress
 */
public class Main  {
	
	/**
	 * simple function for reusing
	 * @param customerDAO
	 */
	public static void showAll (CustomerDAO customerDAO) {
		// SELECT ALL DATA
    	List<Customer> customers = customerDAO.selectAll();
        
    	System.out.println("\n--- CUSTOMER ----- table contents -----------");
        
        for(Customer customer : customers) {
        	System.out.print("Id: " + customer.getId());
        	System.out.println(" - Name: " + customer.getName());
        }

        System.out.println("Total Customers: " + customers.size());	
	}
	
    public static void main( String[] args )
    {
    	CustomerDAO customerDAO = new CustomerDAO();
    	showAll(customerDAO);
            
        // SELECT JUST ONE
        Customer oneCustomer = customerDAO.selectById(1);
    	System.out.println("Selected Name: " + oneCustomer.getName());
    	
        // INSERT NEW DATA
    	Customer newCustomer = new Customer(0,"Phil Anselmo","Suicide note","phil@pantera.com");
    	customerDAO.insert(newCustomer);
    	System.out.println("Inserted id: " + newCustomer.getId());
    	
        System.out.println("Show data after new insert");
    	showAll(customerDAO);
        
        // UPDATE DATA
        newCustomer.setName("Dimebag Darrell");
        customerDAO.update(newCustomer);

        System.out.println("Show data after update");
    	showAll(customerDAO);
        
        // DELETE DATA
        customerDAO.delete(newCustomer);

        System.out.println("Show data after deletion");
    	showAll(customerDAO);
        
    }
}
