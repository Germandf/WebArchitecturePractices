package Daos;

import java.util.List;
import java.util.Optional;

import Interfaces.ICustomerDao;
import Models.Customer;

public class JpaMySqlCustomerDao implements ICustomerDao {

	@Override
	public Optional<Customer> get(int id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public List<Customer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Customer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createTable() {
		// TODO Auto-generated method stub
		
	}

}
