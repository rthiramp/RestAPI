package com.evry.rentamovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evry.rentamovie.enity.AddressEntity;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {


}
