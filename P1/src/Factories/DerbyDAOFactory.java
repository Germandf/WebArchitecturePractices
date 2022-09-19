package Factories;

import java.sql.SQLException;

import Daos.DerbyCustomerDao;
import Interfaces.ICustomerDao;

public class DerbyDAOFactory extends DaoFactory {

	public DerbyDAOFactory() {
		super("org.apache.derby.jdbc.EmbeddedDriver", "jdbc:derby:integratorDB;create=true");
	}

	@Override
	public ICustomerDao getCustomerDao() {
		return new DerbyCustomerDao(getConnection());
	}
	
	@Override
	public boolean hasCreatedTables() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
