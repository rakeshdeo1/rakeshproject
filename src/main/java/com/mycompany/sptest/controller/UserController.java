/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest.controller;

import com.mycompany.sptest.dto.ResponseMessage;
import com.mycompany.sptest.dto.UserDto;
import com.mycompany.sptest.model.User;
import com.mycompany.sptest.service.IuserService;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Prashanna Jung Rana
 */

@RestController
public class UserController {
    //login 
    
    @Autowired
    IuserService iuserService;
    
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public Object login(@RequestBody UserDto user,HttpServletRequest request){
        String token=null;
        if(iuserService.isValid(user.getUsername(), user.getPassword())){
            token=iuserService.getToken(user,request);
            User userTemp=iuserService.getUser(user.getUsername(),user.getPassword());
            userTemp.setToken(token);
            iuserService.save(userTemp);            
        }
        return new ResponseEntity(new ResponseMessage(token),HttpStatus.OK);
    }
}
