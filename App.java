package com.mycompany.app;

import java.io.IOException;

public class App{
    public static void main(String[] args){
        University university = new University("Greenville University");
        university.addStudent("Alex");
        university.addStudent("Bella");
        university.addStudent("Colten");

        try {
            university.loadStudentsFromFile("students.txt");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        university.displayStudents();
    }
}