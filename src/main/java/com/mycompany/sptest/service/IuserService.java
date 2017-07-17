/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest.service;

import com.mycompany.sptest.dto.UserDto;
import com.mycompany.sptest.model.User;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Prashanna Jung Rana
 */
public interface IuserService {
    public void save(User  user);
    public boolean isValid(User user);
    public boolean isValid(String username,String password);
    public boolean isValid(String token);
    public String getToken(UserDto user,HttpServletRequest request);
    public User getUser(String username,String password);
}
