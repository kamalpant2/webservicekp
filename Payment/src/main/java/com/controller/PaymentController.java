package com.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.PaymentResponse;
import com.model.Payment;
import com.service.PaymentService;

@RestController
@RequestMapping("/paymentservice")
public class PaymentController {

	@Autowired
	private PaymentService paymentservice;
	
	@PostMapping("/paynow")
	public PaymentResponse paynow(@RequestBody Payment payment)
	{
		System.out.println("payment paynow method invoked in controller");
		System.out.println("payment object"+payment.toString());
		return paymentservice.pay(payment);
		//return new PaymentResponse();
	}
	
	@GetMapping("/getallpayments/{vendor}") 
	public PaymentResponse getAllPayments(@PathVariable String vendor)
	{
		System.out.println("getallpayments method invoked");
		
		//return new PaymentResponse();
		return paymentservice.getAllPayments(vendor);
	}
	
	@PostConstruct
	protected void iamAlive(){
		System.out.println("paymentcontroller is alive");
	}
}
