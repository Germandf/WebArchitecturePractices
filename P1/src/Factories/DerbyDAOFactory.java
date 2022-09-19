package Factories;

import java.sql.Connection;
import java.sql.SQLException;

import Daos.DerbyCustomerDao;
import Interfaces.ICustomerDao;

public class DerbyDAOFactory extends DaoFactory {

	@Override
	public ICustomerDao getCustomerDao() {
		return new DerbyCustomerDao();
	}

	@Override
	public Connection getConnection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasCreatedTables() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
