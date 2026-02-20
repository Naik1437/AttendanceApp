package com.attendance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/mark")
public class MarkAttendanceServlet extends HttpServlet {

    AttendanceDAO dao = new AttendanceDAO();

    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp)
            throws ServletException, IOException {

        try {

            String subject = req.getParameter("subject");
            String date = req.getParameter("date");

            String[] studentIds = req.getParameterValues("studentId");

            if(studentIds != null){
                for(String sid : studentIds){

                    int id = Integer.parseInt(sid);
                    String status = req.getParameter("status_" + id);

                    dao.markAttendance(id, subject, status, date);
                }
            }

            resp.sendRedirect("dashboard.jsp");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}