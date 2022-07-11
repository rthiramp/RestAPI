package com.evry.rentamovie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.evry.rentamovie.beans.Customer;
import com.evry.rentamovie.util.ListPage;

@Service
public interface CustomerService {

	ListPage getAllCustomers(Integer pageNo, Integer pageSize, String sortBy, String sortOrder);
	
	Customer getCustomerById(long id);
	
	List<Customer> getCustomerByName(String name);
	
	ListPage getCustomersByCity(String city, Integer pageNo, Integer pageSize, String sortBy, String sortOrder);
	
	Customer addCustomer(Customer customer);
	
	Customer updateCustomer(Customer customer);
	
	Customer updateEmailOrAddress(Customer customer);

	void deleteCustomerById(long id);
	
}
