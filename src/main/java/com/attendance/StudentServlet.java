package com.attendance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    AttendanceDAO dao = new AttendanceDAO();

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if("delete".equals(action)){
            int id = Integer.parseInt(req.getParameter("id"));
            dao.deleteStudent(id);
            resp.sendRedirect("students?msg=Deleted Successfully");
            return;
        }

        List<Student> list = dao.getAllStudents();
        req.setAttribute("students", list);
        req.getRequestDispatcher("students.jsp")
                .forward(req, resp);
    }

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        String action = req.getParameter("action");

        if("add".equals(action)){
            String roll = req.getParameter("rollNo");
            String name = req.getParameter("name");

            dao.addStudent(roll, name);
            resp.sendRedirect("students?msg=Student Added");
        }
    }
}