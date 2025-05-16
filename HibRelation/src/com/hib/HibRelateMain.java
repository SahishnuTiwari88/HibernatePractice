/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hib;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
/**
 *
 * @author Bhimsen
 */
public class HibRelateMain {
    public static void main(String[] args) {
    	 Configuration cfg = new Configuration();
         cfg.configure("hibernate.cfg.xml");

         SessionFactory factory = cfg.buildSessionFactory();
         Session session = factory.openSession();
         Transaction trans=session.beginTransaction();
        Certificate cert= new Certificate();
        cert.setId(12);
        cert.setName("OCA");

        Set<Person> set= new HashSet<Person>();
        Person p1=new Person(1011, cert, "Raj");
        Person p2= new Person(1012,cert,"Jaya");
        set.add(p1);
        set.add(p2);
        cert.setPersons(set);
        
        session.save(cert);
        
        session.save(p1);
        session.save(p2);
        trans.commit();
        session.close();
        System.out.println("done");
    }
    
}
