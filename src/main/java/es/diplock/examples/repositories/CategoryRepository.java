package es.diplock.examples.repositories;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import es.diplock.examples.entities.Category;

@Repository
public interface CategoryRepository extends ListCrudRepository<Category, Integer> {}
