/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

/**
 *
 * @author DZ
 */
public class StudentQuizGrades {

    public static void main(String[] args) {

        UserIO io = new Methods();
        StudentInterface si = new StudentMethods();

        boolean exit = false;
        int userChoice;
        String studentName;
        int studentGrade;

        do {
            io.print("-----------------------------------------------------------------------------");
            io.print("-----------------------------------------------------------------------------");
            io.print("                              STUDENT QUIZ GRADES");
            io.print("-----------------------------------------------------------------------------");
            io.print("-----------------------------------------------------------------------------");
            io.print("                                      MENU");
            io.print("-----------------------------------------------------------------------------");
            io.print("                             1: View student list");
            io.print("                             2: Class average");
            io.print("                             3: Highest scoring students");
            io.print("                             4: Lowest scoring students");
            io.print("                             5: Add student to class");
            io.print("                             6: Remove student from class");
            io.print("                             7: View student grades");
            io.print("                             8: View student average");
            io.print("                             9: Add grade");
            io.print("                            10: Remove Grade");
            io.print("                            11: Exit");
            io.print("-----------------------------------------------------------------------------");
            userChoice = io.readInt("Please choose menu option between", 1, 11);

            switch (userChoice) {
                case 1: 
                    si.studentList();
                    
                    break;
                    
                case 2: 
                    si.classAverage();
                    
                    break;
                    
                case 3:
                    si.highScoreStudents(userChoice);
                    
                    break;
                    
                case 4:
                    si.lowScoreStudents(userChoice);
                    
                    break;
                    
                case 5:
                    studentName = io.readString("Enter student name: ");
                    si.addStudent(studentName);
                    
                    break;
                    
                case 6:
                    studentName = io.readString("Enter student name: ");
                    si.removeStudent(studentName);
                    
                    break;
                    
                case 7:
                    studentName = io.readString("Enter student name: ");
                    si.studentGrades(studentName);
                    
                    break;
                    
                case 8:
                    //si.studentAverage(studentName);
                    
                    break;
                    
                case 9:
                    studentName = io.readString("Enter student name: ");
                    studentGrade = io.readInt("Enter grade for student: ");
                    si.addGrade(studentName, studentGrade);
                    
                    break;
                    
                case 10:
                    //si.removeGrade(studentName, userChoice);
                    
                    break;
                    
                case 11:
                    exit = true;
                    
                    break;
            }

            
        } while (exit == false);

    }
}
