/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.dao;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DZ
 */
public class DVDLibraryDaoTest {

    private DVDLibraryDao dao = new DVDLibraryDaoTestFileImpl();

    public DVDLibraryDaoTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() throws Exception {
        List<DVD> dvdList = dao.getAllDVDs();
        for (DVD dvd : dvdList) {
            dao.removeDVD(dvd.getTitle());
        }
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testAddGetDVD() throws Exception {
        DVD dvd = new DVD("Movie1");
        String stringDate = "2018-01-01";
        LocalDate date = LocalDate.parse(stringDate);
        dvd.setDate(LocalDate.parse("2011-01-01"));
        dvd.setDirector("Stephen Spielberg");
        dvd.setStudio("Warner Brothers");
        dvd.setMPAA("R");
        dvd.setComment("Good Movie");

        dao.addDVD(dvd.getTitle(), dvd);

        DVD fromDao = dao.getDVD(dvd.getTitle());

        assertEquals(dvd, fromDao);
    }

    @Test
    public void testGetAllDVDs() throws Exception {
        DVD dvd1 = new DVD("Movie1");
        dvd1.setDate(LocalDate.parse("2011-01-01"));
        dvd1.setDirector("Stephen Spielberg");
        dvd1.setStudio("Warner Brothers");
        dvd1.setMPAA("R");
        dvd1.setComment("Good Movie");

        dao.addDVD(dvd1.getTitle(), dvd1);

        DVD dvd2 = new DVD("Movie2");
        dvd2.setDate(LocalDate.parse("2012-02-02"));
        dvd2.setDirector("James Cameron");
        dvd2.setStudio("Univesal Studios");
        dvd2.setMPAA("PG13");
        dvd2.setComment("Great Movie");

        dao.addDVD(dvd2.getTitle(), dvd2);

        assertEquals(2, dao.getAllDVDs().size());
    }

    @Test
    public void testGetDVD() throws Exception {
        DVD dvd1 = new DVD("Movie1");
        dvd1.setDate(LocalDate.parse("2011-01-01"));
        dvd1.setDirector("Stephen Spielberg");
        dvd1.setStudio("Warner Brothers");
        dvd1.setMPAA("R");
        dvd1.setComment("Good Movie");

        dao.addDVD(dvd1.getTitle(), dvd1);

        assertNotNull(dao.getDVD("Movie1"));
        assertEquals(dao.getDVD("Movie1").getDate(), LocalDate.parse("2011-01-01"));
        assertEquals(dao.getDVD("Movie1").getDirector(), "Stephen Spielberg");
        assertEquals(dao.getDVD("Movie1").getStudio(), "Warner Brothers");
        assertEquals(dao.getDVD("Movie1").getMPAA(), "R");
        assertEquals(dao.getDVD("Movie1").getComment(), "Good Movie");

    }

    @Test
    public void testRemoveDVD() throws Exception {
        DVD dvd1 = new DVD("Movie1");
        dvd1.setDate(LocalDate.parse("2011-01-01"));
        dvd1.setDirector("Stephen Spielberg");
        dvd1.setStudio("Warner Brothers");
        dvd1.setMPAA("R");
        dvd1.setComment("Good Movie");

        dao.addDVD(dvd1.getTitle(), dvd1);

        DVD dvd2 = new DVD("Movie2");
        dvd2.setDate(LocalDate.parse("2012-02-02"));
        dvd2.setDirector("James Cameron");
        dvd2.setStudio("Univesal Studios");
        dvd2.setMPAA("PG13");
        dvd2.setComment("Great Movie");

        dao.addDVD(dvd2.getTitle(), dvd2);

        assertEquals(2, dao.getAllDVDs().size());

        dao.removeDVD("Movie1");
        assertEquals(1, dao.getAllDVDs().size());
        assertNull(dao.getDVD("Movie1"));

        dao.removeDVD("Movie2");
        assertEquals(0, dao.getAllDVDs().size());
        assertNull(dao.getDVD("Movie2"));
    }

    @Test
    public void testEditDVD() throws Exception {
        DVD dvd1 = new DVD("Movie1");
        dvd1.setDate(LocalDate.parse("2011-01-01"));
        dvd1.setDirector("Stephen Spielberg");
        dvd1.setStudio("Warner Brothers");
        dvd1.setMPAA("R");
        dvd1.setComment("Good Movie");

        dao.addDVD(dvd1.getTitle(), dvd1);

        dvd1 = dao.getDVD("Movie1");
        dvd1.setDate(LocalDate.parse("2011-02-02"));
        dvd1.setDirector("New Director");
        dvd1.setStudio("New Studio");
        dvd1.setMPAA("G");
        dvd1.setComment("New Comment");

        dao.editDVD("Movie1", dvd1);

        dvd1 = dao.getDVD("Movie1");

        assertEquals(dvd1.getTitle(), "Movie1");
        assertEquals(dvd1.getDate(), LocalDate.parse("2011-02-02"));
        assertEquals(dvd1.getDirector(), "New Director");
        assertEquals(dvd1.getStudio(), "New Studio");
        assertEquals(dvd1.getMPAA(), "G");
        assertEquals(dvd1.getComment(), "New Comment");

    }

    @Test
    public void testInitDataLoad() throws Exception {
        DVD dvd1 = new DVD("Movie1");
        dvd1.setDate(LocalDate.parse("2011-01-01"));
        dvd1.setDirector("Stephen Spielberg");
        dvd1.setStudio("Warner Brothers");
        dvd1.setMPAA("R");
        dvd1.setComment("Good Movie");

        dao.addDVD(dvd1.getTitle(), dvd1);
        dao.initDataLoad();
        assertNotNull(dao.getAllDVDs());
        assertFalse(dao.getAllDVDs().size() == 0);
        assertFalse(dao.getAllDVDs().isEmpty());

    }

}
