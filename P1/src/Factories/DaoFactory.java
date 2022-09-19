package Factories;

import Interfaces.ICustomerDao;

public abstract class DaoFactory {
	
	public static final int MYSQL_JDBC = 1;
	public static final int DERBY_JDBC = 2;
	public static final int JPA_HIBERNATE = 3;
	
	public abstract ICustomerDao getCustomerDAO();
	
	public static DaoFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case MYSQL_JDBC : return new MySqlDAOFactory();
			case DERBY_JDBC: return new DerbyDAOFactory();
			default: return null;
		}
	}
}
