package com.attendance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    AttendanceDAO dao = new AttendanceDAO();

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        Teacher teacher = dao.login(username, password);

        if (teacher != null) {

            HttpSession session = req.getSession();
            session.setAttribute("teacher", teacher);
            resp.sendRedirect("dashboard.jsp");

        } else {
            req.setAttribute("error", "Invalid Login");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
    }
}