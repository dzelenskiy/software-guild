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
public class StudentMethods implements StudentInterface {

    Map<String, ArrayList<Integer>> students = new HashMap<>();
    ArrayList<Integer> studentGrades = new ArrayList<>();
    

    @Override
    public void studentList() {
        Set<String> keys = students.keySet();
        for (String currentString : keys) {
            System.out.println(currentString);
        }
    }

    @Override
    public void addStudent(String studentName) {
        students.put(studentName, studentGrades);
    }

    @Override
    public void removeStudent(String studentName) {
        students.remove(studentName);
    }

    @Override
    public void studentGrades(String studentName) {
        for (Integer currentGrade : studentGrades) {
            System.out.println(currentGrade);
        }
    }

    @Override
    public void studentAverage(String studentName) {

    }

    @Override
    public void classAverage() {

    }

    @Override
    public void highScoreStudents(int num) {

    }

    @Override
    public void lowScoreStudents(int num) {

    }

    @Override
    public void addGrade(String studentName, Integer grade) {
        students.put(studentName, studentGrades);
    }

    @Override
    public void removeGrade(String studentName, Integer grade) {
        students.remove(studentName, studentGrades);
    }

}
