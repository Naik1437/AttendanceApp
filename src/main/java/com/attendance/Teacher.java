package com.attendance;

public class Teacher {

    private int id;
    private String username;
    private String fullname;

    public Teacher(int id, String username, String fullname) {
        this.id = id;
        this.username = username;
        this.fullname = fullname;
    }

    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getFullname() { return fullname; }
}