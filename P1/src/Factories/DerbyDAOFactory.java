package Factories;

import Daos.DerbyCustomerDAO;
import Interfaces.CustomerDAO;
import Interfaces.DAOFactory;

public class DerbyDAOFactory extends DAOFactory {

	@Override
	public CustomerDAO getCustomerDAO() {
		return new DerbyCustomerDAO();
	}

}
