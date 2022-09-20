package AbstractFactories;

import javax.persistence.EntityManagerFactory;

public abstract class JpaDaoFactory extends DaoFactory {

	public abstract EntityManagerFactory getEntityManagerFactory();
	
}
