package org.cuatrovientos.struts;


import java.util.List;

/**
 * interface for CustomerDAO class
 * @author Pello Xabier Altadill Izura
 *
 */
public interface CustomerDAOInterface {
	
	public Customer selectById(int id);
	public List<Customer> selectAll ();
	public void insert (Customer customer);
	public void update (Customer customer);
	public void delete (Customer customer);

}