package ConcreteFactories;

import AbstractFactories.JpaDaoFactory;
import Daos.JpaDerbyCustomerDao;
import Interfaces.ICustomerDao;

public class JpaDerbyDaoFactory extends JpaDaoFactory {

	@Override
	public ICustomerDao getCustomerDao() {
		return new JpaDerbyCustomerDao();
	}

}
