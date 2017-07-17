package com.mycompany.sptest.repo;

import com.mycompany.sptest.model.PersonModel;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository  extends CrudRepository<PersonModel, Long> {
    
    List<PersonModel> findByName(String name);
}
