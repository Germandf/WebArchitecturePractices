package Main;
import java.util.Optional;

import Factories.DaoFactory;
import Interfaces.ICustomerDao;
import Models.Customer;

public class Main {

	public static void main(String[] args) {
		
		DaoFactory daoFactory = DaoFactory.getDAOFactory(DaoFactory.MYSQL_JDBC);
        DaoFactory.initializeDb(daoFactory);
        
        ICustomerDao customerDao = daoFactory.getCustomerDao();
        customerDao.save(new Customer(1, "German", 21));
		Optional<Customer> maybeCustomer = customerDao.get(1);
		if (maybeCustomer.isPresent()) {
			Customer customer = maybeCustomer.get();
			customer.setAge(22);
			customerDao.update(customer);
			customerDao.delete(customer);
		}
	}
	
}
