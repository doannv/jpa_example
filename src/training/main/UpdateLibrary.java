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

public class UpdateLibrary {
	public static void main(String[] args) {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JpaExample_DoanNV");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		try {
			Library lb = entitymanager.find(Library.class, 1);
			// before updatere
			System.out.println(lb.toString());
			lb.setName("HN");
			entitymanager.getTransaction().commit();
			// after update
			System.out.println(lb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			entitymanager.close();
			emfactory.close();
		}
	}
}
