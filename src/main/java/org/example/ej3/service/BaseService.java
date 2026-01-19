package org.example.ej3.service;

public interface BaseService<T, ID> {
    T findById(ID id);
    void persist(T entity);
    T merge(T entity);
    void remove(T entity);
}
