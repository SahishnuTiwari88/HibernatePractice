package com;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class CRUDProject {
	public static void Insert() {
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
    public static void Delete() {
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
    public static void Update() {

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
    public static void Read() {
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
			
			System.out.print(e.getId()+" ");
			System.out.print(e.getName()+" ");
			System.out.print(e.getAge()+ " ");
			System.out.print(e.getSalary()+" ");
			System.out.print(e.getDesig()+" ");
			System.out.println("------->");
			
		}
	
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n;
		
		do {
			System.out.println("Enter the number you want:");
			System.out.println("1) Insert the record ");
			System.out.println("2) Update the record ");
			System.out.println("3) Delete the record ");
			System.out.println("4) Read the record ");
			System.out.print("5) Exit");
			System.out.println("");
			n=sc.nextInt();
			
			if(n==1) {
				CRUDProject.Insert();
				continue;
			}
			else if(n==2) {
				CRUDProject.Update();
				continue;
			}
			else if(n==3) {
				CRUDProject.Delete();
				continue;
			}
			else if(n==4) {
				CRUDProject.Read();
				continue;
			}
		}
		while(n<5);
		System.out.println("Thank you exit visit again :::::-->");
		
	}

}
