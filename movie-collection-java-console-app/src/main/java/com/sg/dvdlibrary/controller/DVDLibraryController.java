/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.controller;

import com.sg.dvdlibrary.dao.DVDLibraryDaoException;
import com.sg.dvdlibrary.dto.DVD;
import com.sg.dvdlibrary.ui.DVDLibraryView;
import java.util.List;
import com.sg.dvdlibrary.dao.DVDLibraryDao;
import java.time.LocalDate;

/**
 *
 * @author DZ
 */
public class DVDLibraryController {

    DVDLibraryView view;
    DVDLibraryDao dao;

    public DVDLibraryController(DVDLibraryDao dao, DVDLibraryView view) {
        this.dao = dao;
        this.view = view;
    }

    public void run() {
        boolean keepGoing = true;
        int menuSelection = 0;
        try {
            dao.initDataLoad();
            while (keepGoing) {

                menuSelection = getMenuSelection();

                switch (menuSelection) {
                    case 1:
                        listDVDs();
                        break;
                    case 2:
                        addDVD();
                        break;
                    case 3:
                        viewDVD();
                        break;
                    case 4:
                        removeDVD();
                        break;
                    case 5:
                        keepGoing = false;
                        break;
                    default:
                        unknownCommand();
                }

            }
            exitMessage();
        } catch (DVDLibraryDaoException e) {
            view.displayErrorMessage(e.getMessage());
        }
    }

    private int getMenuSelection() {
        return view.printMenuAndGetSelection();
    }

    private void addDVD() throws DVDLibraryDaoException {
        view.displayAddDVDBanner();
        DVD newDVD = view.getNewDVDInfo();
        dao.addDVD(newDVD.getTitle(), newDVD);
        view.displayAddSuccessBanner();
    }

    private void listDVDs() throws DVDLibraryDaoException {
        view.displayDisplayAllBanner();
        List<DVD> dvdList = dao.getAllDVDs();
        view.displayDVDList(dvdList);
    }

    private void viewDVD() throws DVDLibraryDaoException {
        view.displayDisplayDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVD(title);
        view.displayDVD(dvd);
        if (dvd != null) {
            String choice = view.editChoice();
            if (choice.equalsIgnoreCase("y")) {
                editDVD(title, dvd);
            }
        }
    }

    private void removeDVD() throws DVDLibraryDaoException {
        view.displayRemoveDVDBanner();
        String title = view.getTitleChoice();
        DVD dvd = dao.getDVD(title);
        if (dvd != null) {
            dao.removeDVD(title);
            view.displayRemoveSuccessBanner();
        } else {
            view.displayNotFoundBanner();
        }
    }

    private void unknownCommand() {
        view.displayUnknownCommandBanner();
    }

    private void exitMessage() {
        view.displayExitBanner();
    }

    private void editDVD(String title, DVD dvd) throws DVDLibraryDaoException {

        dao.editDVD(title, dvd);
        view.displayEditDVDBanner();

        int field = view.editField();

        switch (field) {
            case 1:
                LocalDate currentDate = dvd.getDate();
                LocalDate newDate = view.editDate("CURRENT DATE:  " + currentDate + "  ENTER NEW DATE IN YYYY-MM-DD FORMAT: ");
                dvd.setDate(newDate);
                view.displayEditSuccessBanner();
                editDVD(title, dvd);
                break;
            case 2:
                String currentDirector = dvd.getDirector();
                String newDirector = view.editField("CURRENT DIRECTOR:  " + currentDirector + "  ENTER NEW DIRECTOR: ");
                dvd.setDirector(newDirector);
                view.displayEditSuccessBanner();
                editDVD(title, dvd);
                break;
            case 3:
                String currentStudio = dvd.getStudio();
                String newStudio = view.editField("CURRENT STUDIO:  " + currentStudio + "  ENTER NEW STUDIO: ");
                dvd.setStudio(newStudio);
                view.displayEditSuccessBanner();
                editDVD(title, dvd);
                break;
            case 4:
                String currentMPAA = dvd.getMPAA();
                String newMPAA = view.editField("CURRENT MPAA:  " + currentMPAA + "  ENTER NEW MPAA: ");
                dvd.setMPAA(newMPAA);
                view.displayEditSuccessBanner();
                editDVD(title, dvd);
                break;
            case 5:
                String currentComment = dvd.getComment();
                String newComment = view.editField("CURRENT COMMENT:  " + currentComment + "  ENTER NEW COMMENT: ");
                dvd.setComment(newComment);
                view.displayEditSuccessBanner();
                editDVD(title, dvd);
                break;
            case 6:
                break;
            default:
                unknownCommand();
        }
        dao.editDVD(title, dvd);
    }
}
