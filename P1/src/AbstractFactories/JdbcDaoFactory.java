package AbstractFactories;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class JdbcDaoFactory extends DaoFactory {

	private final String driver;
	private final String uri;
	
	private Connection connection;
	
	public JdbcDaoFactory(String driver, String uri) {
		this.driver = driver;
		this.uri = uri;
		initializeDb();
	}
	
	private void initializeDb() {
        try {
        	if (hasCreatedTables())
        		return;
        		
        	getCustomerDao().createTable();
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
    
    public abstract boolean hasCreatedTables() throws SQLException;

}
