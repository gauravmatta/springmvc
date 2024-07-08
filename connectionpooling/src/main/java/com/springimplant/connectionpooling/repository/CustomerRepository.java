package com.springimplant.connectionpooling.repository;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.springimplant.connectionpooling.entity.Customers;

@Repository
public interface CustomerRepository extends CrudRepository<Customers, Long> {

	Slice<Customers> findAll(Pageable page);
//	Slice<Customers> partitionMagic(Pageable page);
}
