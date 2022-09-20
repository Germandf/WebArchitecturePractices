package ConcreteFactories;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import AbstractFactories.JpaDaoFactory;
import Daos.JpaCustomerDao;
import Interfaces.ICustomerDao;

public class JpaDerbyDaoFactory extends JpaDaoFactory {

	@Override
	public ICustomerDao getCustomerDao() {
		return new JpaCustomerDao(this);
	}

	@Override
	public EntityManagerFactory getEntityManagerFactory() {
		return Persistence.createEntityManagerFactory("Derby");
	}

}
