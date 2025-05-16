package com;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class UpdateRecord {
	public static void main(String[] args) {
		
		Configuration cfg = new Configuration();
		
		cfg.configure("hibernate1.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Employee e = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID : ");
		int uid = sc.nextInt();
		System.out.println("Enter Salary : ");
		int usalary = sc.nextInt();
		e.setId(uid);
		e.setSalary(usalary);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.update(e);
		tx.commit();
		System.out.println("Record Udpated ....!");
	}

}
