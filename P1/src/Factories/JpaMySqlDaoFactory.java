package Factories;

import java.sql.SQLException;

import Daos.JpaMySqlCustomerDao;
import Interfaces.ICustomerDao;

public class JpaMySqlDaoFactory extends DaoFactory {

	public JpaMySqlDaoFactory() {
		super("", "");
	}
	
	@Override
	public ICustomerDao getCustomerDao() {
		return new JpaMySqlCustomerDao();
	}

	@Override
	public boolean hasCreatedTables() throws SQLException {
		return true;
	}

}
