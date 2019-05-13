/*
	* (C) Copyright 2019 
	*
	* @Author Doan Nguyen
	* @Date May 10, 2019
*/
package training.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import training.model.Library;

public class CreateLibrary {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Library ts1 = new Library();
		ts1.setName("AAAA");
		Library ts2 = new Library();
		ts2.setName("BBBB");
		Library ts3 = new Library();
		ts3.setName("CCCC");
		try {
			// storing all entities
			entitymanager.persist(ts1);
			entitymanager.persist(ts2);
			entitymanager.persist(ts3);
			entitymanager.getTransaction().commit();
		} catch (Exception e) {
			entitymanager.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			entitymanager.close();
			emfactory.close();
		}

	}
}
