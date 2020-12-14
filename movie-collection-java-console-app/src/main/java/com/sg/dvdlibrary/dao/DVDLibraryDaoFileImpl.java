/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author DZ
 */
public class DVDLibraryDaoFileImpl implements DVDLibraryDao {

    private Map<String, DVD> dvds = new HashMap<>();

    public static final String LIBRARY_FILE = "library.txt";

    public static final String DELIMETER = "::";

    private void loadDVDLibrary() throws DVDLibraryDaoException {
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(LIBRARY_FILE)));
        } catch (FileNotFoundException e) {
            throw new DVDLibraryDaoException("-_- Could not load DVD Library into memory.", e);
        }
        String currentLine;
        String[] currentTokens;
        while (scanner.hasNextLine()) {
            currentLine = scanner.nextLine();
            currentTokens = currentLine.split(DELIMETER);
            DVD currentDVD = new DVD(currentTokens[0]);
            currentDVD.setDate(LocalDate.parse(currentTokens[1]));
            currentDVD.setDirector(currentTokens[2]);
            currentDVD.setStudio(currentTokens[3]);
            currentDVD.setMPAA(currentTokens[4]);
            currentDVD.setComment(currentTokens[5]);
            dvds.put(currentDVD.getTitle(), currentDVD);
        }
        scanner.close();
    }

    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(LIBRARY_FILE));
        } catch (IOException e) {
            throw new DVDLibraryDaoException("Could not save DVD data.", e);
        }
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList) {
            out.println(currentDVD.getTitle() + DELIMETER + currentDVD.getDate()
                    + DELIMETER + currentDVD.getDirector() + DELIMETER + currentDVD.getStudio()
                    + DELIMETER + currentDVD.getMPAA() + DELIMETER + currentDVD.getComment());
            out.flush();
        }
        out.close();
    }

    @Override
    public DVD addDVD(String title, DVD dvd)
            throws DVDLibraryDaoException {
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    @Override
    public List<DVD> getAllDVDs()
            throws DVDLibraryDaoException {
        loadDVDLibrary();
        return new ArrayList<DVD>(dvds.values());
    }

    @Override
    public DVD getDVD(String title)
            throws DVDLibraryDaoException {
        loadDVDLibrary();
        return dvds.get(title);
    }
    
    @Override
    public DVD editDVD(String title, DVD dvd)
            throws DVDLibraryDaoException {
        DVD editedDVD = dvds.put(title, dvd);
        writeLibrary();
        return editedDVD;
    }

    @Override
    public DVD removeDVD(String title)
            throws DVDLibraryDaoException {
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }
    
    @Override
    public void initDataLoad() 
            throws DVDLibraryDaoException {
        loadDVDLibrary();
    }
}
