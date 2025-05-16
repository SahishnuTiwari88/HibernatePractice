package com;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class App {
	public static void main (String []args) {
		Configuration cfg= new Configuration();
		cfg.configure("hibernate1.cfg.xml");
		
		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		
		Employee e = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enetr id :");
		int id = sc.nextInt();
		System.out.print("Enter name :");
		String name = sc.next();
		System.out.print("Enter age :");
		int age = sc.nextInt();
		System.out.print("Enter salary :");
		int salary = sc.nextInt();
		System.out.print("Enter designation :");
		String desig = sc.next();
		
		
		
		e.setId(id);
		e.setName(name);
		e.setAge(age);
		e.setSalary(salary);
		e.setDesig(desig);
		
		Query qry = session.createQuery("from Employee");
		List l = qry.list();
		System.out.print("Total number of records :"+l.size());
		Iterator it = l.iterator();
		while(it.hasNext()) {
			Object o = (Object)it.next();
			Employee ep = (Employee)o;
			System.out.println("Employee id :"+ep.getId());
			System.out.println("Name :"+ep.getName());
		}
		
		Transaction tx= session.beginTransaction();
		
		session.save(e);
		tx.commit();
		
		System.out.println("Record Inserted Succefullyy....!");
	}
} 