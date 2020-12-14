/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

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
public class DVDLibraryAuditDaoFileImpl implements DVDLibraryAuditDao {

    public static final String AUDIT_FILE = "audit.txt";
   
    public void writeAuditEntry(String entry) throws DVDLibraryDaoException {
        PrintWriter out;
       
        try {
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not persist audit information.", e);
        }
 
        LocalDateTime currentTime = LocalDateTime.now();
        String timestamp = currentTime.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        
        out.println(timestamp.toString() + " : " + entry);
        out.flush();
    }
    


}
