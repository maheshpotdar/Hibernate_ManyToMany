package com.mahesh.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		// 2 owner 2 car
		// 2 car kade 2 owner.

		Person p1 = new Person();
		p1.setPname("Mahesh");

		Car c1 = new Car();
		c1.setCname("Wagnor");

		List<Car> lstcars = new ArrayList<Car>();
		lstcars.add(c1);

		List<Person> lstperson = new ArrayList<Person>();
		lstperson.add(p1);

		p1.setCar(lstcars);// eka owner kade 2 car
		c1.setPerson(lstperson);// 2 car kade 2 owner

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Person.class)
				.addAnnotatedClass(Car.class).addAnnotatedClass(Car.class).buildSessionFactory();

		Session session = factory.getCurrentSession();
		org.hibernate.Transaction tr = session.beginTransaction();

		session.save(p1);
		session.save(c1);

		tr.commit();
		System.out.println("inserted successfully.");
	}
}
