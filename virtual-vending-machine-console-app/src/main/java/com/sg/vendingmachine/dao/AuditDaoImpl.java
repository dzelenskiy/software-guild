/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 *
 * @author DZ
 */
public class AuditDaoImpl implements AuditDao{
    
    public static final String AUDIT_FILE = "audit.txt";
   
    @Override
    public void writeAuditEntry(String entry) throws VendingInventoryPersistenceException {
        PrintWriter out;
       
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new VendingInventoryPersistenceException("Could not persist audit information.", e);
        }
 
        LocalDateTime currentTime = LocalDateTime.now();
        String timestamp = currentTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        
        out.println(timestamp + ": " + entry);
        out.flush();
    }
    
    
}
