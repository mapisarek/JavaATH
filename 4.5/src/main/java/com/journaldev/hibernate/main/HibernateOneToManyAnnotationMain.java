package com.journaldev.hibernate.main;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.journaldev.hibernate.model.Cart;
import com.journaldev.hibernate.model.Items;
import com.journaldev.hibernate.util.HibernateAnnotationUtil;

public class HibernateOneToManyAnnotationMain {

	@Autowired
	static
	SessionFactory sessionFactory;
	
	public static void main(String[] args) {

		
		Cart cart = new Cart();
		cart.setName("MyCart1");
		
		Items item1 = new Items("I10", 10, 1, cart);
		Items item2 = new Items("I20", 20, 2, cart);
		Set<Items> itemsSet = new HashSet<Items>();
		itemsSet.add(item1); itemsSet.add(item2);
		
		cart.setItems(itemsSet);
		cart.setTotal(10*1 + 20*2);
		
		Session session = null;
		Transaction tx = null;
		
		try{
			
		sessionFactory = HibernateAnnotationUtil.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		System.out.println("Session created");
		
		tx = session.beginTransaction();
		session.save(cart);
		session.save(item1);
		session.save(item2);
		tx.commit();
		System.out.println("Cart1 ID="+cart.getId());
		System.out.println("item1 ID="+item1.getId()+", Foreign Key Cart ID="+item1.getCart().getId());
		System.out.println("item2 ID="+item2.getId()+", Foreign Key Cart ID="+item1.getCart().getId());
		
		}catch(Exception e){
			System.out.println("Exception occured. "+e.getMessage());
			e.printStackTrace();
		}finally{
			if(!sessionFactory.isClosed()){
				System.out.println("Closing SessionFactory");
				sessionFactory.close();
			}
		}
	}
}