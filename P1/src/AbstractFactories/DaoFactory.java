package AbstractFactories;

import ConcreteFactories.DerbyDaoFactory;
import ConcreteFactories.JpaDerbyDaoFactory;
import ConcreteFactories.JpaMySqlDaoFactory;
import ConcreteFactories.MySqlDaoFactory;
import Interfaces.ICustomerDao;

public abstract class DaoFactory {
	
	public static final int MYSQL_JDBC = 1;
	public static final int DERBY_JDBC = 2;
	public static final int MYSQL_JPA_HIBERNATE = 3;
	public static final int DERBY_JPA_HIBERNATE = 4;
	
	public static DaoFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case MYSQL_JDBC: 
				return new MySqlDaoFactory();
			case DERBY_JDBC: 
				return new DerbyDaoFactory();
			case MYSQL_JPA_HIBERNATE: 
				return new JpaMySqlDaoFactory();
			case DERBY_JPA_HIBERNATE: 
				return new JpaDerbyDaoFactory();
			default: return null;
		}
	}
    
    public abstract ICustomerDao getCustomerDao();
    
}
