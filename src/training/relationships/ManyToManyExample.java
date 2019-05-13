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

public class ManyToManyExample {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();

		Student st1 = new Student();
		st1.setS_name("Vipul");
		Student st2 = new Student();
		st2.setS_name("Vimal");

		em.persist(st1);
		em.persist(st2);

		List<Student> al1 = new ArrayList<Student>();
		List<Student> al2 = new ArrayList<Student>();

		al1.add(st1);
		al1.add(st2);

		al2.add(st1);
		al2.add(st2);

		Library lib1 = new Library();
		lib1.setName("Data Structure");
		lib1.setStud(al1);
		
		Library lib2 = new Library();
		lib2.setName("DBMS");
		lib2.setStud(al2);
		
		em.persist(lib1);
		em.persist(lib2);

		em.getTransaction().commit();
		em.close();
		emf.close();

	}
}
