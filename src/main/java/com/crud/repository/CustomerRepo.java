package com.crud.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.crud.model.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	@Query("select e from Customer e where e.cusCity  = :cusCity")
	List<Customer> findByCity(@Param("cusCity")String cusCity);

}
