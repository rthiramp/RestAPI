package com.evry.rentamovie.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evry.rentamovie.beans.Customer;
import com.evry.rentamovie.exceptions.DataInvalidException;
import com.evry.rentamovie.service.CustomerService;
import com.evry.rentamovie.util.ListPage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RequestMapping("/studio")
@RestController
@Validated
@Api(tags = "Customer Controller", value = "Customer Controller")
public class CustomerController {

	private static final String SUCCCESS_MSG = "SUCCESS";
	
	@Autowired
	private CustomerService customerService;
	
	@ApiOperation(value = "Get All Customers")
	@GetMapping("/v1/customers")
	public ResponseEntity<ListPage> getAllCustomers(
			@RequestHeader(name = "Authorization", required = true) String token,
			@RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "pageSize", required = false) Integer  pageSize,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "sortOrder", required = false) String sortOrder) {

		return new ResponseEntity<>(customerService.getAllCustomers(pageNo, pageSize, sortBy, sortOrder), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Get Customer by id")
	@GetMapping("/v1/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("id") long id) {

		return new ResponseEntity<>(customerService.getCustomerById(id), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Get List of Customers by name")
	@GetMapping("/v1/customers/name/{name}")
	public ResponseEntity<List<Customer>> getCustomerById(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("name") String name) {

		return new ResponseEntity<>(customerService.getCustomerByName(name), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Get List of Customers by city")
	@GetMapping("/v1/customers/city/{city}")
	public ResponseEntity<ListPage> getCustomersByCity(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("city") String city,
			@RequestParam(name = "pageNo", required = false) Integer pageNo,
			@RequestParam(name = "pageSize", required = false) Integer  pageSize,
			@RequestParam(name = "sortBy", required = false) String sortBy,
			@RequestParam(name = "sortOrder", required = false) String sortOrder) {

		return new ResponseEntity<>(customerService.getCustomersByCity(city, pageNo, pageSize, sortBy, sortOrder), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Add New Customer")
	@PostMapping("/v1/customers")
	public ResponseEntity<Customer> addCustomer(
			@RequestHeader(name = "Authorization", required = true) String token,
			@Valid @RequestBody Customer customer) {

		return new ResponseEntity<>(customerService.addCustomer(customer), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Update Customer by id")
	@PutMapping("/v1/customers/{id}")
	public ResponseEntity<Customer> updateCustomer(
			@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody Customer customer, @PathVariable("id") long id) throws DataInvalidException {
		if (customer.getId() != id) {
			throw new DataInvalidException("Customer id does not match passed in request body and path param");
		}
		return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);

	}
	
	@ApiOperation(value = "Delete Customer By id")
	@DeleteMapping("/v1/customers/{id}")
	public ResponseEntity<String> deleteCustomerById(
			@RequestHeader(name = "Authorization", required = true) String token,
			@PathVariable("id") long id) {
		customerService.deleteCustomerById(id);
		return new ResponseEntity<>(SUCCCESS_MSG, HttpStatus.OK);

	}

}
