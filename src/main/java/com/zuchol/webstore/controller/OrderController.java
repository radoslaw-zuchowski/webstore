package com.zuchol.webstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zuchol.webstore.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping("/order/2")
	public String process() {
		orderService.processOrder(2, 2);
		return "redirect:/products";
	}

}
