package Factories;

import Daos.MySqlCustomerDao;
import Interfaces.ICustomerDao;

public class MySqlDAOFactory extends DaoFactory {

	@Override
	public ICustomerDao getCustomerDAO() {
		return new MySqlCustomerDao();
	}

}
