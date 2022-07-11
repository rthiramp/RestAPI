package com.evry.rentamovie.service.impl;

import java.lang.reflect.Type;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import com.evry.rentamovie.beans.Customer;
import com.evry.rentamovie.enity.AddressEntity;
import com.evry.rentamovie.enity.CustomerEntity;
import com.evry.rentamovie.enity.EmailEntity;
import com.evry.rentamovie.repository.AddressRepository;
import com.evry.rentamovie.repository.CustomerRepository;
import com.evry.rentamovie.repository.EmailRepository;
import com.evry.rentamovie.service.CustomerService;
import com.evry.rentamovie.util.ListPage;
import com.evry.rentamovie.util.Util;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private EmailRepository emailRepository;
	
	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public ListPage getAllCustomers(Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		Pageable pageable = Util.getPageable(pageNo, pageSize, sortBy, sortOrder);
		Page<CustomerEntity> customerEntityList = customerRepository.findAll(pageable); 
		if (customerEntityList != null && customerEntityList.getSize() > 0) {
			Type customerListType = new TypeToken<List<Customer>>(){}.getType();
			List<Customer> fetchedCustomers = modelMapper.map(customerEntityList.getContent(), customerListType);
			ListPage listPage = new ListPage();
			listPage.setList(fetchedCustomers);
			listPage.setTotal(fetchedCustomers.size());
			listPage.setStartIndex(pageNo);
			listPage.setEndIndex(pageSize);
			listPage.setSortBy(sortBy);
			listPage.setSortOrder(sortOrder);
			return listPage;
		}
		return new ListPage();
	}

	@Override
	public Customer getCustomerById(long id) {
		CustomerEntity customerEntity = customerRepository.findById(id);
		if(customerEntity != null) {
			return modelMapper.map(customerEntity, Customer.class);
		}
		return null;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Customer addCustomer(Customer customer) {
		customer.setCreatetAt(new Timestamp(new Date().getTime()));
		customer.setCreatetBy("superuser");
		CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
		Type emailEntityListType = new TypeToken<List<EmailEntity>>(){}.getType();
		List<EmailEntity> emailEntityList = modelMapper.map(customer.getEmails(), emailEntityListType);
		Type addressEntityListType = new TypeToken<List<AddressEntity>>(){}.getType();
		List<AddressEntity> addressEntityList = modelMapper.map(customer.getAddresses(), addressEntityListType);
		customerEntity.setEmails(new ArrayList<>());
		customerEntity = customerRepository.save(customerEntity);
		for (EmailEntity emailEntity : emailEntityList) {
			emailEntity.setCustomerEntityRef(customerEntity);
			EmailEntity saveEmailEntity = emailRepository.save(emailEntity);
			customerEntity.getEmails().add(saveEmailEntity);
		}
		
//		for (AddressEntity addressEntity : addressEntityList) {
//			addressEntity.setCustomerEntityRef(customerEntity);
//			AddressEntity  saveAddressEntity = addressRepository.save(addressEntity);
//			customerEntity.getAddresses().add(saveAddressEntity);
//		}
		
		
		Customer savedCustomerRecord = modelMapper.map(customerEntity, Customer.class);
		return savedCustomerRecord;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Customer updateCustomer(Customer customer) {
		customer.setUpdatedAt(new Timestamp(new Date().getTime()));
		customer.setUpdatedBy("superuser");
		CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
		customerEntity = customerRepository.saveAndFlush(customerEntity);
		Customer savedCustomerRecord = modelMapper.map(customerEntity, Customer.class);
		return savedCustomerRecord;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public Customer updateEmailOrAddress(Customer customer) {
		customer.setUpdatedAt(new Timestamp(new Date().getTime()));
		customer.setUpdatedBy("superuser");
		CustomerEntity customerEntity = modelMapper.map(customer, CustomerEntity.class);
		customerEntity = customerRepository.saveAndFlush(customerEntity);
		Customer savedCustomerRecord = modelMapper.map(customerEntity, Customer.class);
		return savedCustomerRecord;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteCustomerById(long id) {
		
		customerRepository.deleteById(id);;
	}

	@Override
	public List<Customer> getCustomerByName(String name) {
		List<CustomerEntity> customerEntityList = customerRepository.findByName(name); 
		if (!CollectionUtils.isEmpty(customerEntityList)) {
			Type customerListType = new TypeToken<List<Customer>>(){}.getType();
			return modelMapper.map(customerEntityList, customerListType);
		}
		return Collections.emptyList();
	}

	@Override
	public ListPage getCustomersByCity(String city, Integer pageNo, Integer pageSize, String sortBy, String sortOrder) {
		Pageable pageable = Util.getPageable(pageNo, pageSize, sortBy, sortOrder);
		Page<CustomerEntity> customerEntityList = customerRepository.findByAddresses_city(city, pageable); 
		if (customerEntityList != null && customerEntityList.getSize() > 0) {
			Type customerListType = new TypeToken<List<Customer>>(){}.getType();
			List<Customer> fetchedCustomers = modelMapper.map(customerEntityList.getContent(), customerListType);
			ListPage listPage = new ListPage();
			listPage.setList(fetchedCustomers);
			listPage.setTotal(fetchedCustomers.size());
			listPage.setStartIndex(pageNo);
			listPage.setEndIndex(pageSize);
			listPage.setSortBy(sortBy);
			listPage.setSortOrder(sortOrder);
			return listPage;
		}
		return new ListPage();
	}

}
