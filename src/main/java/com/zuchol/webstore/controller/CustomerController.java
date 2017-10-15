package com.zuchol.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuchol.webstore.service.CustomerSevice;


@Controller
public class CustomerController {

	@Autowired
	private CustomerSevice customerSevice;
	
	
	@RequestMapping("/customers")
	public String customerList(Model model) {
		model.addAttribute("customers", customerSevice.getAllCustomers());
		return "customers";
	}
}
