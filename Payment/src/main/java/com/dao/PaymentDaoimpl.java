package com.dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

import org.springframework.stereotype.Repository;

import com.model.Payment;

@Repository
public class PaymentDaoimpl implements PaymentDao {
	
	@Resource(name="sessionFactory")
	private SessionFactory factory;

	//ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:payment-servlet.xml");
	//SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
	
	public String payNow(Payment payment) {
		// TODO Auto-generated method stub
		getSession().save(payment);
		return "payment successfull";
	}
	
	private Session getSession()
	{
		Session session =null;
		try
		 {
		   session =factory.getCurrentSession();  
		 }
		catch(HibernateException e)
		{
			session =factory.openSession();
		}
		
		return session;
	}

	@SuppressWarnings("unchecked")
	public List<Payment> getAllPayments(String vendor) {
		return getSession().createCriteria(Payment.class).add(Restrictions.eq("vendor", vendor)).list();
		
	}
	
	
	/*public String payNow(Payment payment) {
		// TODO Auto-generated method stub
		System.out.println("saved data is"+payment);
		return "payment successfull";
	}

	public List<Payment> getAllPayments(String vendor) {
		System.out.println(" fethch data for vendor no "+vendor);
		return null;
	}*/
	

}
