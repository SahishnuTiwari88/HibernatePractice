package com;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class GetAllEmployees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg=new 	Configuration ();
		cfg.configure("Hibernate1.cfg.xml");
		SessionFactory factory= cfg.buildSessionFactory();
//		Employee e= new Employee();
		Session session=factory.openSession();
		Transaction tx=(Transaction) session.beginTransaction();
		
		List emps=session.createQuery("from Employee").list();
		Iterator i=emps.iterator();
		while(i.hasNext()) {
			Employee e=(Employee)i.next();
			System.out.println("-------------><---------------");
			System.out.print(e.getId()+" ");
			System.out.print(e.getName()+" ");
			System.out.print(e.getAge()+ " ");
			System.out.print(e.getSalary()+" ");
			System.out.print(e.getDesig()+" ");
			System.out.println("--------------><---------------");
			
		}
		

	}

}
