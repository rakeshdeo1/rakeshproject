/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest.service.impl;

import com.mycompany.sptest.dto.UserDto;
import com.mycompany.sptest.model.User;
import com.mycompany.sptest.repo.UserRepository;
import com.mycompany.sptest.service.IuserService;
import java.util.Base64;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Prashanna Jung Rana
 */

@Service
public  class UserServiceImpl implements IuserService {
    
    @Autowired
    UserRepository userRepository;
    
    
    private static final String SALT="HABIJABI";

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public boolean isValid(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isValid(String username, String password) {
        Long userCount=userRepository.countByUsernameAndPassword(username, password);
        if(userCount>0){
            return true;
        }
        return false;
    }

    @Override
    public boolean isValid(String token) {
        System.out.println("Received Token: "+token);
        System.out.println("Result Token Count: "+userRepository.countByToken(token));
        if(userRepository.countByToken(token)>0){
            return true;
        }
        
        return false;
    }
    
    @Override
    public String getToken(UserDto user,HttpServletRequest request) {
    return generateToken(user,request);
    }
    
    private String generateToken(UserDto user,HttpServletRequest request){
        String remoteIp=request.getRemoteAddr();
        String browser=request.getRemoteHost();
        String username=user.getUsername();
        String randomTime=String.valueOf(System.currentTimeMillis());
        return Base64.getEncoder().encodeToString((remoteIp+browser+username+randomTime+SALT).getBytes());        
    }

    @Override
    public User getUser(String username, String password) {
      return  userRepository.findByUsernameAndPassword(username,password);
    }
    
}
