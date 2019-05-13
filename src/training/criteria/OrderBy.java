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

public class OrderBy {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaExample_DoanNV");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Library lb1 = new Library();
		lb1.setName(null);
		Library lb2 = new Library();
		lb2.setName("BBBB");
		Library lb3 = new Library();
		lb3.setName("CCCC");
		try {
			CriteriaBuilder cb = em.getCriteriaBuilder();
			CriteriaQuery<Library> cq = cb.createQuery(Library.class);

			Root<Library> from = cq.from(Library.class);
			cq.orderBy(cb.asc(from.get("name")));
			cq.select(from);
			TypedQuery<Library> tq = em.createQuery(cq);
			List<Library> list = tq.getResultList();
			if (list == null || list.size() <= 0) {
				System.out.println("Error");
			} else {
				em.getTransaction().commit();
				System.out.println("===========ORDER BY ASC BY NAME=============");
				for (Library lb : list) {
					System.out.print(lb.getId());
					System.out.println("\t" + lb.getName());
				}
			}
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			em.close();
			emf.close();
		}
	}
}
