<%@ page import="java.util.*, com.attendance.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mark Attendance</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<div class="container">

<h2>Mark Attendance</h2>

<%
AttendanceDAO dao = new AttendanceDAO();
List<Student> list = dao.getAllStudents();
%>

<form action="mark" method="post">

Subject:<br>
<input type="text" name="subject" required><br>

Date:<br>
<input type="date" name="date" required><br>

<table>
<tr>
<th>Roll</th>
<th>Name</th>
<th>Status</th>
</tr>

<%
for(Student s : list){
%>
<tr>
<td><%=s.getRollNo()%></td>
<td><%=s.getName()%></td>
<td>
<input type="radio" name="status_<%=s.getId()%>" value="Present" required> Present
<input type="radio" name="status_<%=s.getId()%>" value="Absent"> Absent
<input type="hidden" name="studentId" value="<%=s.getId()%>">
</td>
</tr>
<% } %>

</table>

<br>
<input type="submit" value="Save Attendance">

</form>

<br>
<a href="dashboard.jsp">⬅ Back to Dashboard</a>

</div>

</body>
</html>