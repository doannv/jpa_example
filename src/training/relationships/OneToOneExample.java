/*
	* (C) Copyright 2019 
	*
	* @Author Doan Nguyen
	* @Date May 13, 2019
*/
package training.relationships;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import training.model.Library;
import training.model.Student;

public class OneToOneExample {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try {
			Student st1 = new Student();
			st1.setS_id(1);
			st1.setS_name("Vipul");

			Student st2 = new Student();
			st2.setS_id(2);
			st2.setS_name("Vimal");

			em.persist(st1);
			em.persist(st2);

			Library library1 = new Library();
			library1.setName("Tuoi Tre");
			library1.setStudent(st1);

			Library library2 = new Library();
			library2.setName("Tuoi Gia");
			library2.setStudent(st2);

			em.persist(library1);
			em.persist(library2);

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
