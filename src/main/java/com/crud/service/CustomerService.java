package com.crud.service;

import com.crud.model.Customer;

public interface CustomerService {

	Object saveCustomerDetails(Customer customer);

	Object getAllCustomer();

	Object getCusById(int id);

	Object deleteCustomer(int id);

	Object getByCity(String city);

	Object updateById(int id, Customer customer);

	


}
