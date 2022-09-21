package Main;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import AbstractFactories.DaoFactory;
import Interfaces.ICustomerDao;
import Models.Customer;

public class Main {

	public static void main(String[] args) {
		
		DaoFactory daoFactory = DaoFactory.getDAOFactory(DaoFactory.MYSQL_JPA_HIBERNATE);
        ICustomerDao customerDao = daoFactory.getCustomerDao();
        
        // getAll
        List<Customer> customers = customerDao.getAll();
        int newId = 0;
        if (customers.isEmpty()) {
        	newId = 1;
        	System.out.println("No customers found");
        }
        else {
        	newId = customers.stream().max(Comparator.comparing(Customer::getId)).get().getId() + 1;
        	customers.forEach(customer -> System.out.println(customer));
        }
        
        // save
        Customer customerToSave = new Customer(newId, "German De Francesco", "german@mailing.com");
        customerDao.save(customerToSave);
        System.out.println("Customer added");
        
        // get
        Optional<Customer> maybeCustomer = customerDao.get(newId);
        Customer customer = maybeCustomer.get();
        System.out.println("Customer added last obtained");
        
        // update
        customer.setEmail("german2@mailing.com");
        customerDao.update(customer);
        System.out.println("Customer updated");
        
        // delete
        //customerDao.delete(customer);
        //System.out.println("Customer deleted");
	}
	
}
