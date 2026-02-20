<%@ page import="com.attendance.Teacher" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<%
Teacher t = (Teacher) session.getAttribute("teacher");
if(t==null){
    response.sendRedirect("login.jsp");
    return;
}
%>

<div class="container">

<h2>Welcome, <%=t.getFullname()%></h2>

<div style="margin-top:20px;">
    <p><a href="mark.jsp">Mark Attendance</a></p>
    <p><a href="report">View Report</a></p>
    <p><a href="students">Manage Students</a></p>
    <p><a href="logout">Logout</a></p>
</div>

</div>

</body>
</html>