package com.attendance;

public class Student {

    private int id;
    private String rollNo;
    private String name;

    public Student(int id, String rollNo, String name) {
        this.id = id;
        this.rollNo = rollNo;
        this.name = name;
    }

    public int getId() { return id; }
    public String getRollNo() { return rollNo; }
    public String getName() { return name; }
}