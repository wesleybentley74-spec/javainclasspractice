package com.mycompany.app;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class University {
    private String name;
    private List<Student> students;
    private int nextId = 1;
    
    public University(String name){
        this.name = name;
        this.students = new ArrayList<>();
    }

    public void addStudent(String name){
        Student student = new Student(name, nextId++);
        students.add(student);
    }

    public void loadStudentsFromFile(String filename) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    addStudent(line.trim());
                }
            }
        }
    }

    public void displayStudents(){
        for( Student student : students){
            student.printUniversity();
        }
    }

    private class Student{
        private String name;
        private int id;

        public Student(String name, int id){
            this.name = name;
            this.id = id;
        }

        public void printUniversity(){
            System.out.println(name + " belongs to " + University.this.name + " with ID: " + id);
        }
    }
}