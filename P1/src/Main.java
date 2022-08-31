import java.util.Optional;

public class Main {

	public static void main(String[] args) {
		DAOFactory mysqlFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL_JDBC);
		CustomerDAO customerDAO = mysqlFactory.getCustomerDAO();
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
