package org.example.ej3.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.JPAUtil;
import org.example.ej3.repository.Repository;

public class Service<T> implements BaseService<T, Long>{
    Repository<T> repository = new Repository<>();
    @Override
    public T findById(Long id) {
        try (EntityManager em = JPAUtil.getEntityManager()) {
            return repository.findById(em, id);
        }
    }
    @Override
    public void persist(T entity) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            repository.persist(em, entity);
        } finally {
            tx.commit();
            em.close();
        }
    }
    @Override
    public T merge(T entity) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            return repository.merge(em, entity);
        } finally {
            tx.commit();
            em.close();
        }
    }
    @Override
    public void remove(T entity) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            repository.remove(em, entity);
        } finally {
            tx.commit();
            em.close();
        }
    }
}
