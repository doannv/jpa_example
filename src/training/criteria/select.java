/*
	* (C) Copyright 2019 
	*
	* @Author Doan Nguyen
	* @Date May 13, 2019
*/
package training.criteria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import training.model.Library;

public class Select {
	public static void main(String args[]) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Library lb1 = new Library();
		lb1.setName("AAAA");
		Library lb2 = new Library();
		lb2.setName("BBBB");
		Library lb3 = new Library();
		lb3.setName("CCCC");
		try {
			em.persist(lb1);
			em.persist(lb2);
			em.persist(lb3);
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Library> cq = cb.createQuery(Library.class);
			Root<Library> from = cq.from(Library.class);
			cq.select(from);
			TypedQuery<Library> tq = em.createQuery(cq);
			List<Library> list = tq.getResultList();
			if (list == null || list.size() <= 0) {
				System.out.println("Error");
			} else {
				System.out.println("Successfully");
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		} finally {
			em.close();
			emf.close();
		}
	}
}
