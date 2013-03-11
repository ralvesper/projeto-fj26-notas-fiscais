package br.com.caelum.notasfiscais.dao;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("notas");
	
	@Produces @RequestScoped
	public EntityManager getEntityManager() {
		EntityManager em =  emf.createEntityManager();
		em.getTransaction().begin();
		return em;
	}
	
	public void close(@Disposes EntityManager em) {
		em.getTransaction().commit();
		em.close();
	}
}
