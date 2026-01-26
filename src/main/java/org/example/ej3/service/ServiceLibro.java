package org.example.ej3.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.ej3.JPAUtil;
import org.example.ej3.model.Libro;
import org.example.ej3.repository.RepositoryLibro;

public class ServiceLibro implements BaseService<Libro, Long>{
    @Override
    public Libro findById(Long id) {
        RepositoryLibro repository = new RepositoryLibro();
        EntityManager em = JPAUtil.getEntityManager();
        Libro libro = repository.findById(em, id);
        em.close();
        return libro;
    }

    @Override
    public void persist(Libro entity) {
        RepositoryLibro repository = new RepositoryLibro();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        repository.persist(em, entity);
        tx.commit();
        em.close();
    }

    @Override
    public Libro merge(Libro entity) {
        RepositoryLibro repository = new RepositoryLibro();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Libro libro = repository.merge(em, entity);
        tx.commit();
        em.close();
        return libro;
    }

    @Override
    public void remove(Libro entity) {
        RepositoryLibro repository = new RepositoryLibro();
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        repository.remove(em, entity);
        tx.commit();
        em.close();
    }
}
