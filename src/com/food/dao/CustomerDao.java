package com.food.dao;
import com.food.model.*;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service @Transactional
public class CustomerDao {
	@Resource  SessionFactory factory;
	public void addCustomer(Customer customer)throws Exception{
		Session s=factory.getCurrentSession();
		s.save(customer);
		}
	public void deleteCustomer(Integer customerid)throws Exception{
		Session s=factory.getCurrentSession();
		Object customer =s.load(Customer.class,customerid);
		s.delete(customer);
	}
}
