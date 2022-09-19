package Main;
import java.util.Optional;

import Factories.DaoFactory;
import Interfaces.ICustomerDao;
import Models.Customer;

public class Main {

	public static void main(String[] args) {
		DaoFactory mysqlFactory = DaoFactory.getDAOFactory(DaoFactory.MYSQL_JDBC);
		ICustomerDao customerDAO = mysqlFactory.getCustomerDAO();
		customerDAO.save(new Customer(1, "German", 21));
		Optional<Customer> maybeCustomer = customerDAO.get(1);
		if (maybeCustomer.isPresent()) {
			Customer customer = maybeCustomer.get();
			customer.setAge(22);
			customerDAO.update(customer);
			customerDAO.delete(customer);
		}
	}
	
}
