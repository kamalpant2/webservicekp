package com.dao;

import java.util.List;

import com.model.Payment;

public interface PaymentDao {
	
	public String payNow(Payment payment);
   public List<Payment> getAllPayments(String vendor);
}
