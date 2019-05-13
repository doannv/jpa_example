/*
	* (C) Copyright 2019 
	*
	* @Author Doan Nguyen
	* @Date May 13, 2019
*/
package training.advancedMapping.singleTable;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmployeePersistence {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		ActiveEmployee ae1 = new ActiveEmployee(101, "Karun", 10000, 5);
		ActiveEmployee ae2 = new ActiveEmployee(102, "Rishab", 12000, 7);

		RetiredEmployee re1 = new RetiredEmployee(103, "Ramesh", 5000);
		RetiredEmployee re2 = new RetiredEmployee(104, "Raj", 4000);
		try {
			em.persist(ae1);
			em.persist(ae2);
			em.persist(re1);
			em.persist(re2);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
