package ConcreteFactories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import AbstractFactories.JdbcDaoFactory;
import Daos.JdbcMySqlCustomerDao;
import Interfaces.ICustomerDao;

public class MySqlDaoFactory extends JdbcDaoFactory {

	public MySqlDaoFactory() {
		super("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/practice1DB");
	}
	
	@Override
	public ICustomerDao getCustomerDao() {
		return new JdbcMySqlCustomerDao(getConnection());
	}

	@Override
	public boolean hasCreatedTables() throws SQLException {
		boolean exists = false;
        String select = """
        		SELECT * 
				FROM information_schema.tables
				WHERE table_schema = 'practice1DB' 
				    AND table_name = 'customer'
				LIMIT 1;
        		""";
        var connection = getConnection();
        try (PreparedStatement ps = connection.prepareStatement(select)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next())
            	exists = true;
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
	}

}
