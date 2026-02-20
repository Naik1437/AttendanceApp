package com.attendance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/report")
public class ReportServlet extends HttpServlet {

    AttendanceDAO dao = new AttendanceDAO();

    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp)
            throws ServletException, IOException {

        List<String[]> list = dao.getAttendanceReport();

        req.setAttribute("report", list);
        req.getRequestDispatcher("report.jsp")
                .forward(req, resp);
    }
}