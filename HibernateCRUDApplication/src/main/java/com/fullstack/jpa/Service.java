package com.fullstack.jpa;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Service {

	private static SessionFactory factory = new Configuration().configure().buildSessionFactory();

	public static void main(String[] args) {

		Service service = new Service();

		//CRUD
		
		//service.create();
		
		//service.readById(2);
		
		//service.readAll();
		
		//service.update(1);
		
		service.deleteById(1);
		
		

	}

	void create() {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = new Employee("PRATISH", 92000.96);

		session.save(employee);

		transaction.commit();
	}

	void readById(int empId) {
		Session session = factory.openSession();

		Employee employee = session.get(Employee.class, empId);

		System.out.println(employee);

	}

	void readAll() {
		Session session = factory.openSession();

		List<Employee> employees = session.createQuery("from Employee").list();

		System.out.println(employees);
	}

	void update(int empId) {

		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, empId);

		employee.setEmpName("LAKSHMI");
		employee.setEmpSalary(99000.99);

		session.update(employee);

		transaction.commit();

	}

	void deleteById(int empId) {
		Session session = factory.openSession();

		Transaction transaction = session.beginTransaction();

		Employee employee = session.get(Employee.class, empId);

		session.delete(employee);

		transaction.commit();
	}

}
