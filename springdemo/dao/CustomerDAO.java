package springdemo.dao;

import java.util.List;

import springdemo.entity.Customer;
import springdemo.entity.CustomerDetail;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	
	public List<Customer> searchCustomers(String theSearchName);
	
	public void saveCustomerDetail(CustomerDetail theCustomerDetail);
	
	public List<CustomerDetail> getCustomerDetails();
	
	public CustomerDetail getCustomerDetail(int theId);
}
