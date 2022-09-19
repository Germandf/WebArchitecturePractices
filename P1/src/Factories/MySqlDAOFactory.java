package Factories;

import java.sql.Connection;
import java.sql.SQLException;

import Daos.MySqlCustomerDao;
import Interfaces.ICustomerDao;

public class MySqlDAOFactory extends DaoFactory {

	@Override
	public ICustomerDao getCustomerDao() {
		return new MySqlCustomerDao(getConnection());
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
