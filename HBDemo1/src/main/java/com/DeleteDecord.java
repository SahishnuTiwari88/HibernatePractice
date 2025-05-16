package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteDecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate1.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Employee e = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID : ");
		int uid = sc.nextInt();
		e.setId(uid);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.delete(e);
		tx.commit();
		System.out.println("Record Deleted ....!");

	}

}
