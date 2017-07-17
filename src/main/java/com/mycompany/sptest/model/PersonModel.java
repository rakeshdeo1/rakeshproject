/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Prashanna Jung Rana
 */

@Entity
public class PersonModel {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @NotNull(message="name cannot be null.")
    @Size(min = 5,max = 20)
    private String name;
    private String subject;
    
    
    public PersonModel(){
        
    }

    
    public PersonModel(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public PersonModel(Long id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }
    
    
    
    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
       return name;
    }
    public void setSubject(String subject){
        this.subject = subject;
    }
    public String getSubject(){
        return subject;
    }
    
    
}
