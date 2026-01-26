package org.example.ej3.repository;

import jakarta.persistence.EntityManager;

public class Repository<T> implements BaseRepository<T, Long>{
    @Override
    public T findById(EntityManager em, Long aLong) {
        return em.find(T.class, aLong);
    }

    @Override
    public void persist(EntityManager em, T entity) {
        em.persist(entity);
    }

    @Override
    public T merge(EntityManager em, T entity) {
        return em.merge(entity);
    }

    @Override
    public void remove(EntityManager em, T entity) {
        em.remove(entity);
    }
}
