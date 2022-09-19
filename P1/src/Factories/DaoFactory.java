package Factories;

import java.sql.Connection;
import java.sql.SQLException;

import Interfaces.ICustomerDao;

public abstract class DaoFactory {
	
	public static final int MYSQL_JDBC = 1;
	public static final int DERBY_JDBC = 2;
	public static final int JPA_HIBERNATE = 3;
	
	public abstract ICustomerDao getCustomerDao();
	
	public static DaoFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case MYSQL_JDBC : return new MySqlDAOFactory();
			case DERBY_JDBC: return new DerbyDAOFactory();
			default: return null;
		}
	}
	
	public static void initializeDb(DaoFactory daoFactory) {
        try {
        	if (daoFactory.hasCreatedTables())
        		return;
        		
        	daoFactory.getCustomerDao().createTable();
            System.out.println("Tables created with success!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public abstract Connection getConnection();
    
    public abstract boolean hasCreatedTables() throws SQLException;
}
