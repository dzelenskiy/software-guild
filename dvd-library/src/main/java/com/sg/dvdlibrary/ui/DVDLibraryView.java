/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dvdlibrary.ui;

import com.sg.dvdlibrary.dto.DVD;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author DZ
 */
public class DVDLibraryView {

    private UserIO io;

    public DVDLibraryView(UserIO io) {
        this.io = io;
    }

    public int printMenuAndGetSelection() {
        io.print("             %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        io.print("             %%   ________________________   %%");
        io.print("             %%  |    ***-Main Menu-***   |  %%");
        io.print("             %%  |                        |  %%");
        io.print("             %%  |   1. See DVD Library   |  %%");
        io.print("             %%  |   2. Add New DVD       |  %%");
        io.print("             %%  |   3. View/Edit DVD     |  %%");
        io.print("             %%  |   4. Remove a DVD      |  %%");
        io.print("             %%  |   5. Exit              |  %%");
        io.print("             %%  |________________________|  %%");
        io.print("             %%                              %%");
        io.print("             %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        io.print("                                               ");
        return io.readInt("          * Please select from the above choices *", 1, 5);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("                 * Please enter DVD Title *");
        String stringDate = io.readString("* Please enter Release Date in YYYY-MM-DD format *");
        LocalDate date = LocalDate.parse(stringDate);
        String director = io.readString("          * Please enter Director *");
        String studio = io.readString("          * Please enter Studio *");
        String mpaa = io.readString("          * Please enter MPAA Rating *");
        String comment = io.readString("          * Please enter Additional Comment *");
        DVD currentDVD = new DVD(title);
        currentDVD.setDate(date);
        currentDVD.setDirector(director);
        currentDVD.setStudio(studio);
        currentDVD.setMPAA(mpaa);
        currentDVD.setComment(comment);
        return currentDVD;
    }

    public void displayAddDVDBanner() {
        io.print("               *^*^*^*^*^* Add DVD *^*^*^*^*^*");
    }

    public void displayAddSuccessBanner() {
        io.print(" ");
        io.readString("    * DVD successfully added. Please hit enter to continue *");
    }

    public void displayDVDList(List<DVD> dvdList) {
        for (DVD currentDVD : dvdList) {
            io.print("TITLE: " + currentDVD.getTitle() + "    RELEASE DATE: " + currentDVD.getDate()
                    + "    DIRECTOR: " + currentDVD.getDirector());
            io.print("STUDIO: " + currentDVD.getStudio() + "    RATED: " + currentDVD.getMPAA()
                    + "    USER COMMENT: " + currentDVD.getComment());
            io.print(" ");
        }
        io.print(" ");
        io.readString("              * Please hit enter to continue *");
    }

    public void displayDisplayAllBanner() {
        io.print(" ");
        io.print("          *^*^*^*^*^* Display All DVDs *^*^*^*^*^*");
        io.print(" ");
    }

    public void displayDisplayDVDBanner() {
        io.print(" ");
        io.print("            *^*^*^*^*^* Display DVD *^*^*^*^*^*");
        io.print(" ");
    }

    public String getTitleChoice() {
        return io.readString("                 * Please enter DVD Title *");
    }

    public void displayDVD(DVD dvd) {
        if (dvd != null) {
            io.print(" ");
            io.print(dvd.getTitle());
            io.print(dvd.getDate() + " " + dvd.getDirector());
            io.print(dvd.getStudio() + " " + dvd.getMPAA());
            io.print(dvd.getComment());
            io.print(" ");
        } else {
            io.print(" ");
            displayNotFoundBanner();
            io.print(" ");
        }
        io.print(" ");
    }

    public String editChoice() {
        String choice = io.readString("* Would you like to Edit DVD Info? Enter y/n*");
        return choice;
    }

    public int editField() {
        io.print("             %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        io.print("             %%   ________________________   %%");
        io.print("             %%  |    ***-Edit Menu-***   |  %%");
        io.print("             %%  |                        |  %%");
        io.print("             %%  |   1. Release Date      |  %%");
        io.print("             %%  |   2. Director          |  %%");
        io.print("             %%  |   3. Studio            |  %%");
        io.print("             %%  |   4. MPAA Rating       |  %%");
        io.print("             %%  |   5. Comment           |  %%");
        io.print("             %%  |   6. Main Menu         |  %%");
        io.print("             %%  |________________________|  %%");
        io.print("             %%                              %%");
        io.print("             %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
        io.print("                                               ");
        int field = io.readInt("          * Please select from the above choices * ", 1, 6);
        return field;
    }

    public String editField(String currentInfo) {
        String newInfo = io.readString(currentInfo);
        return newInfo;
    }

    public LocalDate editDate(String currentInfo) {
        String newInfo = io.readString(currentInfo);
        LocalDate newDate = LocalDate.parse(newInfo);
        return newDate;
    }

    public void displayRemoveDVDBanner() {
        io.print(" ");
        io.print("             *^*^*^*^*^* Remove DVD *^*^*^*^*^*");
        io.print(" ");
    }

    public void displayRemoveSuccessBanner() {
        io.print(" ");
        io.readString("    * DVD successfully removed. Please hit enter to continue *");
    }

    public void displayEditDVDBanner() {
        io.print(" ");
        io.print("              *^*^*^*^*^* Edit DVD *^*^*^*^*^*");
        io.print(" ");
    }

    public void displayEditSuccessBanner() {
        io.print(" ");
        io.readString("* DVD  information successfully changed. Please hit enter to continue *");
    }

    public void displayExitBanner() {
        io.print(" ");
        io.print("                       * Good Bye!!! *");
    }

    public void displayUnknownCommandBanner() {
        io.print(" ");
        io.print("                  * !! Unknown Command !! *");
    }

    public void displayErrorMessage(String errorMsg) {
        io.print(" ");
        io.print("                *^*^*^*^*^* ERROR *^*^*^*^*^*");
        io.print(errorMsg);
    }

    public void displayNotFoundBanner() {
        io.print(" ");
        io.print("                    * !! No such DVD !! *");
    }
}
