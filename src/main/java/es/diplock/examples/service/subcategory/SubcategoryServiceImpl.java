package es.diplock.examples.service.subcategory;

import org.springframework.stereotype.Service;

import es.diplock.examples.dtos.subcategory.SubcategoryDTO;
import es.diplock.examples.entities.Subcategory;
import es.diplock.examples.repositories.SubcategoryRepository;
import es.diplock.examples.service.AbstractGenericService;

@Service
public class SubcategoryServiceImpl extends AbstractGenericService<Subcategory, Integer, SubcategoryDTO>{

    private SubcategoryServiceImpl(SubcategoryRepository subcategoryRepository) {
        super(subcategoryRepository);
    }

    @Override
    public Subcategory save(SubcategoryDTO saveDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public Subcategory update(Integer id, SubcategoryDTO updateDTO) {
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    
}
