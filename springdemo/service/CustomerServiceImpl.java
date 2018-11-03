package springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import springdemo.dao.CustomerDAO;
import springdemo.entity.Customer;
import springdemo.entity.CustomerDetail;

@Service
public class CustomerServiceImpl implements CustomerService {

	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;


	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}


	@Transactional
	public void saveCustomer(Customer theCustomer) {

		customerDAO.saveCustomer(theCustomer);
	}

	@Transactional
	public Customer getCustomer(int theId) {

		return customerDAO.getCustomer(theId);
	}
	@Override
	@Transactional
	public List<Customer> searchCustomers(String theSearchName) {

		return customerDAO.searchCustomers(theSearchName);
	}
	@Transactional
	public void deleteCustomer(int theId) {

		customerDAO.deleteCustomer(theId);
	}


	
	public void saveCustomerDetail(CustomerDetail theCustomerDetail) {
		customerDAO.saveCustomerDetail(theCustomerDetail);
		
	}


	@Override
	public List<CustomerDetail> getCustomerDetails() {
		return customerDAO.getCustomerDetails();
	}


	@Override
	public CustomerDetail getCustomerDetail(int theId) {
		return customerDAO.getCustomerDetail(theId);
	}
}





