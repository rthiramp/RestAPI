package com.evry.rentamovie.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evry.rentamovie.enity.CustomerEntity;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	Page<CustomerEntity> findAll(Pageable pageable);
	
	CustomerEntity findById(long id);
	
	List<CustomerEntity> findByName(String name);
	
	Page<CustomerEntity> findByAddresses_city(String name, Pageable pageable);
	//List<CustomerEntity> findByAddresses_city(String name, Pageable pageable);
	

}
