package com.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PaymentDao;
import com.dto.PaymentResponse;
import com.model.Payment;

@Service
@Transactional
public class PaymentService {

	@Autowired
	private PaymentDao paymentdao;
	
	@Autowired
	
	private PaymentResponse paymentresponse;
	
	public PaymentResponse pay(Payment payment)
	{
		payment.setPaymentDate(new Date());
		String message=paymentdao.payNow(payment);
		if(null!=message)
		{
			
			paymentresponse.setStatus("success");
			paymentresponse.setMessage(message);
			//paymentresponse.setTransactiondate(new SimpleDateFormat("dd-mm-yyyy HH:MM:SS a").format(new Date()));
			paymentresponse.setTransactiondate(new Date().toString());
		}
		
		return paymentresponse;
		
	}
	
	public PaymentResponse getAllPayments(String vendor)
	{
		
		List <Payment> allpayments=paymentdao.getAllPayments(vendor);
		if(null!=allpayments && !allpayments.isEmpty())
		{
			paymentresponse.setStatus("success");
			paymentresponse.setPayments(allpayments);
			System.out.println("allpayments in if="+allpayments);
			return paymentresponse;
			
		}
		else
		{

			paymentresponse.setStatus("Record Not Found!!");
			paymentresponse.setPayments(null);
			System.out.println("allpayments in else="+allpayments);
			return paymentresponse;
		}
		
		
		
		
	}
	
	
	
	
}
