/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest.dto;

/**
 *
 * @author Prashanna Jung Rana
 */
public class UserDto {
    
    private Long id;
    private String username;
    private String password;
    private String token;
    private String status;

    public UserDto(){
    
    }
    
    public UserDto(Long id, String username, String password, String token, String status){
        this.id = id;
        this.username = username;
        this.password = password;
        this.token = token;
        this.status = status; 
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
