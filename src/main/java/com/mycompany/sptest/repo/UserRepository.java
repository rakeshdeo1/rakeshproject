/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sptest.repo;

import com.mycompany.sptest.model.PersonModel;
import com.mycompany.sptest.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Prashanna Jung Rana
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Long countByUsernameAndPassword(String username,String password);    
    User findByUsernameAndPassword(String username,String password);
    Long countByToken(String token);
    User findByToken(String token);
}
