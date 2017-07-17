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
public class ResponseMessage {
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
    }

    public ResponseMessage() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    
    
}
