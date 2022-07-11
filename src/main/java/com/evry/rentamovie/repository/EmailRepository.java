package com.evry.rentamovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.evry.rentamovie.enity.EmailEntity;

@Repository
public interface EmailRepository extends JpaRepository<EmailEntity, Long> {


}
