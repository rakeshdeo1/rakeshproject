/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest.service;

import com.mycompany.sptest.dto.PersonDto;
import com.mycompany.sptest.dto.UpdatePersonDto;
import com.mycompany.sptest.model.PersonModel;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycompany.sptest.repo.CustomerRepository;
import java.util.List;
import java.util.function.Consumer;

@Service
public class PersonService {
    
    private static List<String> names=Arrays.asList("A","B","C");
   // private static List<String> fruitList = Arrays.asList("Apple","Banana","Orange");
    
    @Autowired
    CustomerRepository customerRepository;
    
    //by rakesh alternate way.
    public Iterable<PersonModel> getNamesList(){
        return customerRepository.findAll();
    }
    
    /*public Iterable<PersonModel> getNames(){
        return customerRepository.findAll();
     } */
    
    public void save(PersonDto personDto){
        PersonModel p=new PersonModel(personDto.getName(),personDto.getSubject());
        customerRepository.save(p);
    }
        
    public Iterable<PersonModel> getAll(){
        return customerRepository.findAll();
    }
    
    public void deletePersonModel(Long id){
        customerRepository.delete(id);
    }
    
    public void update(UpdatePersonDto person){
        PersonModel model=new PersonModel(person.getId(),
                person.getName(),person.getSubject());
        customerRepository.save(model);
    }
    
    
    public void updateByName(String name,String subject){
       List<PersonModel> models=customerRepository.findByName(name);
       models.forEach(p->p.setSubject(subject));
       
       for(PersonModel p:models){
           customerRepository.save(p);          
       }
       
    }
}
