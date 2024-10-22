package es.diplock.examples.service;

import java.util.List;

public interface GenericService<T, ID, S> {
    List<T> findAll();
    T findById(ID id);
    T save(S saveDTO);
    T update(ID id, S updateDTO);
    void delete(ID id);
}