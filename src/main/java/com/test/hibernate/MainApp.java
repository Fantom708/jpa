package com.test.hibernate;

import javax.persistence.EntityManager;

import com.test.hibernate.entity.Student;
import com.test.hibernate.entity.Book;

public class MainApp {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

//		// Check database version
//		String sql = "select version()";
//
//		String result = entityManager.createNativeQuery(sql).getSingleResult().toString();
//		System.out.println(result);
		entityManager.persist(new Book("Dark night"));
		
		Student st = new Student();
		st.setFirstName("Дмитрий1");
		st.setLastName("Дюжев1");
		st.setAge(329);
//		
//		entityManager.persist(st);
//		entityManager.persist(new Student("Богдан", "Нелипа", 31));

		st.setBook(new Book("Fight"));
		entityManager.persist(st);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();

		JPAUtil.shutdown();
	}
}