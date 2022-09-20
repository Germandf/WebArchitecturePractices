package ConcreteFactories;

import AbstractFactories.JpaDaoFactory;
import Daos.JpaMySqlCustomerDao;
import Interfaces.ICustomerDao;

public class JpaMySqlDaoFactory extends JpaDaoFactory {
	
	@Override
	public ICustomerDao getCustomerDao() {
		return new JpaMySqlCustomerDao();
	}

}
