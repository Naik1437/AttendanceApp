<%@ page import="java.util.*, com.attendance.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Manage Students</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body class="bg-soft">

<h2>Manage Students</h2>

<%
String msg = request.getParameter("msg");
if(msg != null){
%>
<div class="alert alert-success"><%=msg%></div>
<% } %>

<% if(request.getAttribute("error") != null){ %>
<div class="alert alert-danger"><%=request.getAttribute("error")%></div>
<% } %>

<!-- ADD STUDENT FORM -->
<form action="students" method="post">
    <input type="hidden" name="action" value="add">

    Roll No: <input type="text" name="rollNo" required>
    Name: <input type="text" name="name" required>

    <input type="submit" value="Add Student">
</form>

<br>

<table border="1">
<tr>
    <th>#</th>
    <th>Roll No</th>
    <th>Name</th>
    <th>Actions</th>
</tr>

<%
List<Student> students = (List<Student>) request.getAttribute("students");

if(students != null && !students.isEmpty()){
    int i = 1;
    for(Student s : students){
%>

<tr>
    <td><%=i++%></td>
    <td><%=s.getRollNo()%></td>
    <td><%=s.getName()%></td>
    <td>
        <a href="students?action=edit&id=<%=s.getId()%>">Edit</a>
        |
        <a href="students?action=delete&id=<%=s.getId()%>"
           onclick="return confirm('Delete this student?');">
           Delete
        </a>
    </td>
</tr>

<%
    }
}else{
%>
<tr>
<td colspan="4">No students found.</td>
</tr>
<% } %>

</table>

<br>
<a href="dashboard.jsp">Back to Dashboard</a>

</body>
</html>