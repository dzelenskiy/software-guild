/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.flooringmastery.dao;

/**
 *
 * @author DZ
 */
public class DataFileError extends Exception{
    
    public DataFileError(String message) {
    super(message);
    }

    public DataFileError(String message, Throwable cause) {
    super(message, cause);
    }
    
}
