package Interfaces;

import Models.Customer;

public interface ICustomerDao extends IDao<Customer> {

	public String entityName = "customer";
	
}
