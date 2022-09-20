package ConcreteFactories;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

import AbstractFactories.JdbcDaoFactory;
import Daos.JdbcDerbyCustomerDao;
import Interfaces.ICustomerDao;

public class DerbyDaoFactory extends JdbcDaoFactory {

	public DerbyDaoFactory() {
		super("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:practice1DB;create=true");
	}

	@Override
	public ICustomerDao getCustomerDao() {
		return new JdbcDerbyCustomerDao(getConnection());
	}
	
	@Override
	public boolean hasCreatedTables() throws SQLException {
		boolean exists = false;
		var connection = getConnection();
		DatabaseMetaData dbm = connection.getMetaData();
        ResultSet rs = dbm.getTables(null, "ROOT", "CUSTOMER", null);
        if (rs.next())
            exists = true;
        return exists;
	}

}
