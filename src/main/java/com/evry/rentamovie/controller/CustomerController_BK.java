//package com.evry.rentamovie.controller;
//
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.evry.rentamovie.beans.Address;
//import com.evry.rentamovie.beans.Customer;
//
//@RestController
//public class CustomerController_BK {
//	
//	@GetMapping("/customers")
//	public List<Customer> getAllCustomers() {
//		List<Customer> customers = new ArrayList<>();
//		Customer c1 = new Customer();
//		c1.setId(1);
//		c1.setName("John");
//		Set<String> emails = new HashSet<>();
//		emails.add("john@gmail.com");
//		emails.add("john@hostmail.com");
//		c1.setEmails(emails);
//		List<Address> addresses = new ArrayList<>();
//		Address address1 = new Address();
//		address1.setId(101);
//		address1.setDoorno("10-4-5");
//		address1.setFloor("1st Floor");
//		address1.setBuilding("Shoba Appartments");
//		address1.setStreet("MG Road");
//		address1.setCity("Bangalore");
//		address1.setCustomer_id(1);
//		address1.setPostalcode("556677");
//		address1.setAddressType("Home");
//		
//		Address address2 = new Address();
//		address2.setId(102);
//		address2.setDoorno("77-99");
//		address2.setFloor("10th Floor");
//		address2.setBuilding("Prestige Group");
//		address2.setStreet("WhiteField");
//		address2.setCity("Bangalore");
//		address2.setCustomer_id(1);
//		address2.setPostalcode("556633");
//		address2.setAddressType("Office");
//		
//		addresses.add(address1);
//		addresses.add(address2);
//		c1.setAddresses(addresses);
//		
//		
//		Customer c2 = new Customer();
//		c2.setId(2);
//		c2.setName("Ram");
//		Set<String> emailsram = new HashSet<>();
//		emailsram.add("ram@gmail.com");
//		emailsram.add("ram@hostmail.com");
//		c2.setEmails(emailsram);
//		List<Address> addressesram = new ArrayList<>();
//		Address addressram1 = new Address();
//		addressram1.setId(101);
//		addressram1.setDoorno("10-4-5");
//		addressram1.setFloor("1st Floor");
//		addressram1.setBuilding("Shoba Appartments");
//		addressram1.setStreet("MG Road");
//		addressram1.setCity("Bangalore");
//		addressram1.setCustomer_id(2);
//		addressram1.setPostalcode("556677");
//		addressram1.setAddressType("Home");
//		
//		Address addressram2 = new Address();
//		addressram2.setId(102);
//		addressram2.setDoorno("77-99");
//		addressram2.setFloor("10th Floor");
//		addressram2.setBuilding("Prestige Group");
//		addressram2.setStreet("WhiteField");
//		addressram2.setCity("Bangalore");
//		addressram2.setCustomer_id(2);
//		addressram2.setPostalcode("556633");
//		addressram2.setAddressType("Office");
//		
//		addresses.add(addressram1);
//		addresses.add(addressram2);
//		
//		addressesram.add(addressram1);
//		addressesram.add(addressram2);
//		
//		c1.setAddresses(addresses);
//		c2.setAddresses(addressesram);
//		
//		customers.add(c1);
//		customers.add(c2);
//		return customers;
//	}
//	
//}
