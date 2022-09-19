package Factories;

import Daos.MySqlCustomerDAO;
import Interfaces.CustomerDAO;
import Interfaces.DAOFactory;

public class MySqlDAOFactory extends DAOFactory {

	@Override
	public CustomerDAO getCustomerDAO() {
		return new MySqlCustomerDAO();
	}

}
