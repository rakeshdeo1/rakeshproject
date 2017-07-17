/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest;

public class Greeting {

    private final long id;
    private final String content;
    private String country;

    public Greeting(long id, String content, String country) {
        this.id = id;
        this.content = content;
        this.country = country;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
    
    public String getCountry(){
        return country;
    }
}