package com.attendance;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebFilter({"/dashboard.jsp", "/mark.jsp", "/report", "/students"})
public class AuthFilter implements Filter {

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        HttpSession session = req.getSession(false);

        if (session == null || session.getAttribute("teacher") == null) {
            resp.sendRedirect("login.jsp");
            return;
        }

        chain.doFilter(request, response);
    }
}