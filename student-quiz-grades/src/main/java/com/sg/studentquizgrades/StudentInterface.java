/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.studentquizgrades;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author DZ
 */
public interface StudentInterface {

    void studentList();

    void addStudent(String studentName);

    void removeStudent(String studentName);

    void addGrade(String studentName, Integer grade);

    void removeGrade(String studentName, Integer grade);

    void studentGrades(String studentName);

    void studentAverage(String studentName);

    void classAverage();

    void highScoreStudents(int num);

    void lowScoreStudents(int num);

}
