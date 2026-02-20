package com.attendance;

import java.sql.*;
import java.util.*;

public class AttendanceDAO {

    // ===== LOGIN =====
    public Teacher login(String username, String password) {
        try (Connection con = DBUtil.getConnection()) {

            String sql = "SELECT * FROM teacher WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Teacher(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("fullname")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // ===== STUDENTS =====
    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection()) {
            String sql = "SELECT * FROM student ORDER BY roll_no";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Student(
                        rs.getInt("id"),
                        rs.getString("roll_no"),
                        rs.getString("name")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean addStudent(String roll, String name) {
        try (Connection con = DBUtil.getConnection()) {
            String sql = "INSERT INTO student(roll_no,name) VALUES(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, roll);
            ps.setString(2, name);
            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStudent(int id) {
        try (Connection con = DBUtil.getConnection()) {

            String sql1 = "DELETE FROM attendance WHERE student_id=?";
            PreparedStatement ps1 = con.prepareStatement(sql1);
            ps1.setInt(1, id);
            ps1.executeUpdate();

            String sql2 = "DELETE FROM student WHERE id=?";
            PreparedStatement ps2 = con.prepareStatement(sql2);
            ps2.setInt(1, id);

            return ps2.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    // ===== MARK ATTENDANCE =====
    public void markAttendance(int studentId, String subject, String status, String date) throws Exception {

        try (Connection con = DBUtil.getConnection()) {

            String sql = "INSERT INTO attendance(student_id,subject,date,status) VALUES(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);
            ps.setString(2, subject);
            ps.setString(3, date);
            ps.setString(4, status);

            ps.executeUpdate();
        }
    }

    // ===== REPORT =====
    public List<String[]> getAttendanceReport() {

        List<String[]> list = new ArrayList<>();

        try (Connection con = DBUtil.getConnection()) {

            String sql =
                    "SELECT student.roll_no, student.name, subject, date, status " +
                    "FROM attendance INNER JOIN student " +
                    "ON student.id = attendance.student_id ORDER BY date DESC";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new String[]{
                        rs.getString("roll_no"),
                        rs.getString("name"),
                        rs.getString("subject"),
                        rs.getString("date"),
                        rs.getString("status")
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}