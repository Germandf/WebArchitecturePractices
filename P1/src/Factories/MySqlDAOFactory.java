package Factories;

import java.sql.SQLException;

import Daos.MySqlCustomerDao;
import Interfaces.ICustomerDao;

public class MySqlDAOFactory extends DaoFactory {

	public MySqlDAOFactory() {
		super("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/integratorDB");
	}
	
	@Override
	public ICustomerDao getCustomerDao() {
		return new MySqlCustomerDao(getConnection());
	}

	@Override
	public boolean hasCreatedTables() throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

}
