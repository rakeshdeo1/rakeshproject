/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Prashanna Jung Rana
 */
public class PersonDto {
    
    @NotNull(message="name cannot be null.")
    @Size(min=3,max=6,message="name should be length of 3 to 6 char.")
    private String name;
    private String subject;

    public PersonDto() {
    }

    public PersonDto(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
