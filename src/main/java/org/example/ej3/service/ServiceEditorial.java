package org.example.ej3.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.JPAUtil;
import org.example.ej3.model.Editorial;
import org.example.ej3.repository.RepositoryEditorial;

public class ServiceEditorial implements BaseService<Editorial, Long> {
    @Override
    public Editorial findById(Long id) {
        RepositoryEditorial repository = new RepositoryEditorial();
        EntityManager em = JPAUtil.getEntityManager();
        Editorial editorial = repository.findById(em, id);
        em.close();
        return editorial;
    }

    @Override
    public void persist(Editorial entity) {
        RepositoryEditorial repository = new RepositoryEditorial();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        repository.persist(em, entity);
        tx.commit();
        em.close();
    }

    @Override
    public Editorial merge(Editorial entity) {
        RepositoryEditorial repository = new RepositoryEditorial();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Editorial editorial = repository.merge(em, entity);
        tx.commit();
        em.close();
        return editorial;
    }

    @Override
    public void remove(Editorial entity) {
        RepositoryEditorial repository = new RepositoryEditorial();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        repository.remove(em, entity);
        tx.commit();
        em.close();
    }
}
