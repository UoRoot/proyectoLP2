package es.diplock.examples.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import jakarta.persistence.EntityNotFoundException;

public abstract class AbstractGenericService<T, ID, S> implements GenericService<T, ID, S> {
    
    // Inyectar un repositorio genérico
    protected final JpaRepository<T, ID> repository;
    
    protected AbstractGenericService(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }
    
    @Override
    public List<T> findAll() {
        return repository.findAll();
    }
    
    @Override
    public T findById(ID id) {
        return repository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Entity not found with id: " + id));
    }
    
    @Override
    public abstract T save(S saveDTO);  // Debe ser implementado por las clases hijas
    
    @Override
    public abstract T update(ID id, S updateDTO);  // Debe ser implementado por las clases hijas
    
    @Override
    public void delete(ID id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("Entity not found with id: " + id);
        }
        repository.deleteById(id);
    }
}