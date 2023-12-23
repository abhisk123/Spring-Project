package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Customer;
import com.crud.service.CustomerService;

@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/savecus")
	public Object saveCustomer(@RequestBody Customer customer){
		return (customerService.saveCustomerDetails(customer));
		
	}
	@GetMapping("/getcustomer")
	public Object getcus() {
		return (customerService.getAllCustomer());
		
	}
	@GetMapping("/getbyid/{id}")
	public Object getbyid(@PathVariable int id) {
		return (customerService.getCusById(id));
		
	}
	 @DeleteMapping("/delcus/{id}")
	    public Object deleteemp(@PathVariable int id) {
			return (customerService.deleteCustomer(id));
	    	
	    }
	 @GetMapping("/getbycity")
	    public Object getempbycity(@RequestParam String cusCity) {
			return (customerService.getByCity(cusCity));
	    	
	    }
	 @PutMapping("/updatebyid/{id}")
	 public Object updatebyid(@PathVariable("id")int id,@RequestBody Customer customer) {
		return (customerService.updateById(id,customer));
		 
	 }

}
