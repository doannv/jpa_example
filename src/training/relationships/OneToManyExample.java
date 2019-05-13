/*
	* (C) Copyright 2019 
	*
	* @Author Doan Nguyen
	* @Date May 13, 2019
*/
package training.relationships;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import training.entities.Library;
import training.entities.Student;

public class OneToManyExample {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Library lib1 = new Library();
		lib1.setName("Data Structure");

		Library lib2 = new Library();
		lib2.setName("DBMS");
		em.persist(lib1);
		em.persist(lib2);

		List<Library> list = new ArrayList<Library>();
		list.add(lib1);
		list.add(lib2);

		Student st1 = new Student();
		st1.setS_id(1);
		st1.setS_name("Vipul");

		st1.setBooks_issued(list);

		em.persist(st1);

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
