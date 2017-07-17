/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest;

import com.mycompany.sptest.dto.PersonDto;
import com.mycompany.sptest.dto.ResponseMessage;
import com.mycompany.sptest.dto.UpdatePersonDto;
import com.mycompany.sptest.model.PersonModel;
import com.mycompany.sptest.service.PersonService;
import java.util.concurrent.atomic.AtomicLong;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Prashanna Jung Rana
 */
@RestController
public class Controller {
    
    @Autowired
    PersonService personService;
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World New") String name) {
         //return new Greeting(counter.incrementAndGet(),String.format(template, name));
         return new Greeting(100,String.format(template, name),  "Nepal");

    }
         
    @RequestMapping("/save")
    public ResponseEntity<Object> save(@Validated @RequestBody PersonDto person){      
        personService.save(person);
        return new ResponseEntity(person,HttpStatus.OK);
    }
    
    @RequestMapping("/getAllList")
    public ResponseEntity<Object> getNamesList(){
        return new ResponseEntity(personService.getNamesList(), HttpStatus.OK);
    }
    
    @RequestMapping("/get-all")
    public ResponseEntity<Object> getAll(){
        return new ResponseEntity(personService.getAll(),HttpStatus.OK);
    }
    @RequestMapping("/remove/{id}")
    public ResponseEntity<Object> detId(@PathVariable("id") Long id){
        personService.deletePersonModel(id);
        ResponseMessage message=new ResponseMessage("deleted successfully");
        return new ResponseEntity(message,HttpStatus.OK);
    }
    
    @RequestMapping(value="/update",method = RequestMethod.POST)
    public ResponseEntity<Object> update(@RequestBody UpdatePersonDto updatePersonDto){
        personService.update(updatePersonDto);
        return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value="/update/{name}/{subject}",method=RequestMethod.POST)
    public ResponseEntity<Object> updateMultiCondition(
            @PathVariable("name") String name,
            @PathVariable("subject")String subject){
        personService.updateByName(name,subject);
         return new ResponseEntity(HttpStatus.OK);
    }
    
    @RequestMapping(value="/update-with-validation/",method=RequestMethod.DELETE)
    public ResponseEntity<Object> updateWithValidation(
            @RequestBody @Valid UpdatePersonDto updatePersonDto){
        personService.update(updatePersonDto);
        return new ResponseEntity(HttpStatus.OK);
    }
}
