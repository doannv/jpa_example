/*
	* (C) Copyright 2019 
	*
	* @Author Doan Nguyen
	* @Date May 10, 2019
*/
package training.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import training.entities.Library;

public class findLibraryById {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager entitymanager = emfactory.createEntityManager();
		Query query = entitymanager.createNamedQuery("findLibraryById");

		query.setParameter("id", 1);
		List<Library> list = query.getResultList();
		for (Library lb : list) {
			System.out.println("Library ID :" + lb.getId());
			System.out.println("Library Name :" + lb.getName());
		}
	}
}
