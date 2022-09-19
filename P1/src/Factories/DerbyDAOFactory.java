package Factories;

import Daos.DerbyCustomerDao;
import Interfaces.ICustomerDao;

public class DerbyDAOFactory extends DaoFactory {

	@Override
	public ICustomerDao getCustomerDAO() {
		return new DerbyCustomerDao();
	}

}
