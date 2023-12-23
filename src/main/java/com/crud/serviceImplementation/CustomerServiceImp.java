package com.crud.serviceImplementation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.model.Customer;
import com.crud.repository.CustomerRepo;
import com.crud.service.CustomerService;

@Service
public class CustomerServiceImp  implements CustomerService{
	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public Object saveCustomerDetails(Customer customer) {
		Map<String,Object>map = new HashMap<String, Object>();
	
		if(customer.getCusName().isEmpty()) {
			map.put("status", "error");
			map.put("msg","Please enter the employee name");
			
		}
		else if(customer.getCusCity().isEmpty()) {
			map.put("status", "error");
			map.put("msg","Please enter the department");
			
		}
		else if(customer.getCusState().isEmpty()) {
			map.put("status", "error");
			map.put("msg","Please enter the date of birth");
			
		}
		else if(customer.getCusPincode()==0.0) {
			map.put("status", "error");
			map.put("msg","Please enter the salary");
			
		}
		else {
			customerRepo.save(customer);
			map.put("status","success");
			map.put("mag","Data saved successfully");
		}
		return map;
	}

	@Override
	public Object getAllCustomer() {
		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		List<Customer> customers = customerRepo.findAll();
		for(Customer e:customers) {
			Map<String,Object>map1 = new HashMap<String, Object>();
			map1.put("Employee Id", e.getCusName());
			map1.put("Employee Name", e.getCusCity());
			map1.put("Employee DOB", e.getCusState());
			map1.put("Employee Department", e.getCusPincode());
			list.add(map1);
		}
		return list;

	}

	@Override
	public Object getCusById(int id) {
		Map<String,Object>map = new HashMap<String, Object>();
		Customer customer = customerRepo.findById(id).orElse(null);
		if(customer!=null) {
			map.put("Employee Id", customer.getCustomerId());
			map.put("Employee Name", customer.getCusName());
			map.put("Employee DOB", customer.getCusCity());
			map.put("Employee Department", customer.getCusState());
			map.put("Employee Salary", customer.getCusPincode());
			return map;
		}
		
		return map;
		
	}

	@Override
	public Object deleteCustomer(int id) {
		Map<String,Object>map = new HashMap<String, Object>();
		Customer customer = customerRepo.findById(id).orElse(null);
		if(customer!=null) {
			customerRepo.delete(customer);
			map.put("status","success");
			map.put("msg","Data deleted successfully");
		}
		else {
			map.put("status","error");
			map.put("msg","Employee ID does not exists");
		}

		return map;

	}

	@Override
	public Object getByCity(String city) {
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		List<Customer> customers = customerRepo.findByCity(city);
		for(Customer e:customers) {
			Map<String,Object>map = new HashMap<String, Object>();
			map.put("Customer Id", e.getCustomerId());
			map.put("Customer Name", e.getCusName());
			map.put("Customer City", e.getCusCity());
			map.put("Customer State ", e.getCusState());
			map.put("Customer Pincode", e.getCusPincode());
			list.add(map);
		}
		return list;
	}

	@Override
	public Object updateById(int id, Customer customer) {
		Map<String, Object> map = new HashMap<String, Object>();
		Customer customer2 = customerRepo.findById(id).orElse(null);
		
		if(customer2!=null) {
			customer2.setCusName(customer.getCusName());
			customer2.setCusCity(customer.getCusCity());
			customer2.setCusState(customer.getCusState());
			customer2.setCusPincode(customer.getCusPincode());
			
			customerRepo.saveAndFlush(customer2);
			map.put("status","success");
			map.put("msg","Data saved successfully");
		}
		else {
				
			map.put("status","error");
			map.put("msg","Customer Id doesn't exists");
		}
		return map;
		
	}

	
	}
	
	
	


