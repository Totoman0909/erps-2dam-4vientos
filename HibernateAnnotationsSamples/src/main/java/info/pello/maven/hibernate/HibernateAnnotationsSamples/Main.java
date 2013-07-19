package info.pello.maven.hibernate.HibernateAnnotationsSamples;

import java.util.ArrayList;
import java.util.List;

/**
 * Main class
 * @author Pello Xabier Altadill Izura
 * @greetz 4 u
 * @listening "Seasons in the Abyss - Slayer"
 * Close your eyes 
 * Look deep in your soul 
 * Step outside yourself 
 * And let your mind go 
 * Frozen eyes stare deep in your mind as you die 
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
	
	/**
	 * simple function for reusing
	 * @param customerDAO
	 */
	public static void showAllCars (CarDAOInterface carDAO) {
		// SELECT ALL DATA
    	List<Car> cars = carDAO.selectAll();
        
    	System.out.println("\n--- CARS ----- table contents -----------");
        
        for(Car car : cars) {
        	System.out.print("Id: " + car.getId());
        	System.out.print(" - Model: " + car.getModel());
        	System.out.println(" - Insurance: " + car.getInsurance().getCompany());
        }

        System.out.println("Total cars: " + cars.size());	
	}
	
	
	/**
	 * simple function for reusing
	 * @param productDAOInterface
	 */
	public static void showAllProducts (ProductDAOInterface productDAOInterface) {
		// SELECT ALL DATA
    	List<Product> products = productDAOInterface.selectAll();
    	String productDesc = "";
        
    	System.out.println("\n--- Products ----- table contents -----------");
        
        for(Product product : products) {
        	productDesc = "Id: " + product.getId() + 
        					" - Name: " + product.getName() +
        					" - Type: " + product.getProductType().getName();
        	System.out.println(productDesc);
        }

        System.out.println("Total products: " + products.size());	
	}

	/**
	 * simple function for reusing
	 * @param productDAOInterface
	 */
	public static void showAllProductTypes (ProductTypeDAOInterface productTypeDAO) {
		// SELECT ALL DATA
    	List<ProductType> productTypes = productTypeDAO.selectAll();
    	String productDesc = "";
        
    	System.out.println("\n--- ProductsTypes ----- table contents -----------");
        
        for(ProductType productType : productTypes) {
        	productDesc = "Id: " + productType.getId() + 
        					" - Name: " + productType.getName() +
        					" - Products: \n";
        	productDesc += productType.getProducts().toString() + "\n";
        	
        	System.out.println(productDesc);
        }

        System.out.println("Total products: " + productTypes.size());	
	}

	
    public static void main( String[] args )
    {
    	/*
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
        */
    	/*
    	CarDAOInterface carDAO = new CarDAO();
    	
    	showAllCars(carDAO);
    	
        // SELECT JUST ONE
        Car oneCar = carDAO.selectById(1);
    	System.out.println("Selected Name: " + oneCar.getRegistration());
    	
        // INSERT NEW DATA
    	Insurance insurance = new Insurance("Lagun Aro","Full",666.66);
    	Car newCar = new Car(0,"5646DFR","Volkswagen passat");
    	newCar.setInsurance(insurance);
    	insurance.setCar(newCar);
    	
    	carDAO.insert(newCar);
    	
    	System.out.println("Inserted id: " + newCar.getId());
    	
        System.out.println("Show data after new insert");
    	showAllCars(carDAO);
        
        // UPDATE DATA
        newCar.setModel("Seat Panda TDI");
        carDAO.update(newCar);

        System.out.println("Show data after update");
    	showAllCars(carDAO);
        
        // DELETE DATA
        carDAO.delete(newCar);
        */

    	ProductDAOInterface productDAO = new ProductDAO();
    	ProductTypeDAOInterface productTypeDAO = new ProductTypeDAO();
    	
    	showAllProducts(productDAO);
    	
    	
        // SELECT JUST ONE
        Product oneProduct = productDAO.selectById(1);
    	System.out.println("Selected Name: " + oneProduct.getName());
    	
    	
        // INSERT NEW DATA
    	ProductType productType = new ProductType("Luxurious");
    	productTypeDAO.insert(productType);
    	Product newProduct = new Product("Angulas","Angulas de Aginaga", productType);
    	
    	productDAO.insert(newProduct);
    	
    	System.out.println("Inserted id: " + newProduct.getId());
    	
        System.out.println("Show data after new insert");
    	showAllProducts(productDAO);
        
        // UPDATE DATA
        newProduct.setName("Piperrark");
        productDAO.update(newProduct);

        System.out.println("Show data after update");
    	showAllProducts(productDAO);
        
        // DELETE DATA
        productDAO.delete(newProduct);
    	showAllProducts(productDAO);
    	
    	showAllProductTypes(productTypeDAO);

    }
}
