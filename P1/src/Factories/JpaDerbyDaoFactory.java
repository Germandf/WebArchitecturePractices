package Factories;

import java.sql.SQLException;

import Daos.JpaDerbyCustomerDao;
import Interfaces.ICustomerDao;

public class JpaDerbyDaoFactory extends DaoFactory {

	public JpaDerbyDaoFactory() {
		super("", "");
	}

	@Override
	public ICustomerDao getCustomerDao() {
		return new JpaDerbyCustomerDao();
	}

	@Override
	public boolean hasCreatedTables() throws SQLException {
		return true;
	}

}
