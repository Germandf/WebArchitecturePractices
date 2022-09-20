package Main;
import java.util.Optional;

import AbstractFactories.DaoFactory;
import Interfaces.ICustomerDao;
import Models.Customer;

public class Main {

	public static void main(String[] args) {
		
		DaoFactory daoFactory = DaoFactory.getDAOFactory(DaoFactory.MYSQL_JPA_HIBERNATE);
        
        ICustomerDao customerDao = daoFactory.getCustomerDao();
        customerDao.save(new Customer(1, "German De Francesco", "german@mailing.com"));
		Optional<Customer> maybeCustomer = customerDao.get(1);
		if (maybeCustomer.isPresent()) {
			System.out.println("Working!");
			Customer customer = maybeCustomer.get();
			customer.setEmail("german2@mailing.com");
			customerDao.update(customer);
			customerDao.delete(customer);
		}
	}
	
}
