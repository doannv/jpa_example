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

import training.entities.Library;

public class OrderBy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Library lb1 = new Library("AAAA");
		Library lb2 = new Library("BBBB");
		Library lb3 = new Library("CCCC");
		em.persist(lb1);
		em.persist(lb2);
		em.persist(lb3);

		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Library> cq = cb.createQuery(Library.class);

		Root<Library> from = cq.from(Library.class);
		cq.orderBy(cb.asc(from.get("name")));
		cq.select(from);
		TypedQuery<Library> tq = em.createQuery(cq);
		List<Library> list = tq.getResultList();

		System.out.println("===========ORDER BY ASC BY NAME=============");
		for (Library lb : list) {
			System.out.print(lb.getId());
			System.out.println("\t" + lb.getName());
		}

		em.getTransaction().commit();
		em.close();
		emf.close();
	}
}
