/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.vendingmachine.advice;

import com.sg.vendingmachine.dao.AuditDao;
import com.sg.vendingmachine.dao.VendingInventoryPersistenceException;
import org.aspectj.lang.JoinPoint;
import java.lang.Exception;

/**
 *
 * @author DZ
 */
public class LoggingAdvice {

    AuditDao auditDao;

    public LoggingAdvice(AuditDao auditDao) {
        this.auditDao = auditDao;
    }

    public void createAuditEntry(JoinPoint jp, Exception x) {
        Object[] args = jp.getArgs();
        String auditEntry = "Tried: " + jp.getSignature().getName();
        String itemNumber = args[0].toString();
        String userCash = args[1].toString();
        String fullError = x.toString();
        int endOfMessage = fullError.length() - 1;
        String error = fullError.substring(25, endOfMessage);
        auditEntry += "-MENU_OPTION:" + itemNumber + " with $" + userCash + " recieved ERROR_MESSAGE:" + error;

        try {
            auditDao.writeAuditEntry(auditEntry);
        } catch (VendingInventoryPersistenceException e) {
            System.err.println("ERROR: Could not create audit entry in LoggingAdvice.");
        }
    }

}
