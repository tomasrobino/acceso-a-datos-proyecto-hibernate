package org.example.ej3.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import org.example.ej3.model.Libro;

public class Repository implements BaseRepository<Libro, Long>{
    @Override
    public Libro findById(EntityManager em, Long aLong) {
        return em.find(Libro.class, aLong);
    }

    @Override
    public void persist(EntityManager em, Libro entity) {
        em.persist(entity);
    }

    @Override
    public Libro merge(EntityManager em, Libro entity) {
        return em.merge(entity);
    }

    @Override
    public void remove(EntityManager em, Libro entity) {
        em.remove(entity);
    }
}
