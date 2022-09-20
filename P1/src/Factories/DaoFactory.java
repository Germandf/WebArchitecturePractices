package Factories;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import Interfaces.ICustomerDao;

public abstract class DaoFactory {
	
	public static final int MYSQL_JDBC = 1;
	public static final int DERBY_JDBC = 2;
	public static final int MYSQL_JPA_HIBERNATE = 3;
	public static final int DERBY_JPA_HIBERNATE = 4;
	
	private final String driver;
	private final String uri;
	
	private Connection connection;
	
	public DaoFactory(String driver, String uri) {
		this.driver = driver;
		this.uri = uri;
	}
	
	public static DaoFactory getDAOFactory(int whichFactory) {
		switch (whichFactory) {
			case MYSQL_JDBC: return new MySqlDaoFactory();
			case DERBY_JDBC: return new DerbyDaoFactory();
			case MYSQL_JPA_HIBERNATE: return new JpaMySqlDaoFactory();
			case DERBY_JPA_HIBERNATE: return new JpaDerbyDaoFactory();
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
    
    public Connection getConnection() {
    	
    	if (connection != null)
            return connection;
    	
        try {
            Class.forName(driver).getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
                | NoSuchMethodException | SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            connection = DriverManager.getConnection(uri, "root", "");
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
    
    public abstract ICustomerDao getCustomerDao();
    
    public abstract boolean hasCreatedTables() throws SQLException;
}
