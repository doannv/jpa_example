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

import training.entities.Library;

public class CreateLibrary {
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Library ts1 = new Library("Tri Duc");
		Library ts2 = new Library("Tuoi Tre");
		Library ts3 = new Library("Su Pham");
		
		// storing all entities
		entitymanager.persist(ts1);
		entitymanager.persist(ts2);
		entitymanager.persist(ts3);
		entitymanager.getTransaction().commit();
		entitymanager.close();
		emfactory.close();
	}
}
