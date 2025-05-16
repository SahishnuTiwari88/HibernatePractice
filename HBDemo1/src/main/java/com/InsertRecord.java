package com;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class InsertRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Configuration cfg = new Configuration();
		cfg.configure("hibernate1.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		Employee e = new Employee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID : ");
		int uid = sc.nextInt();
		System.out.println("ENTER NAME : ");
		String name = sc.next();
		System.out.println("Enter AGE : ");
		int uage = sc.nextInt();
		System.out.println("Enter SALARY : ");
		int usalary = sc.nextInt();
		System.out.println("ENTER Desig : ");
		String desig = sc.next();
		e.setId(uid);
		e.setName(name);
		e.setAge(uage);
		e.setSalary(usalary);
		e.setDesig(desig);
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(e);
		tx.commit();
		System.out.println("Record Inserted Succefullyy....!");

	}

}
