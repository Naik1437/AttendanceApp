<%@ page import="com.attendance.Student" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Student</title>
    <link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<h2>Edit Student</h2>

<%
Student s = (Student) request.getAttribute("student");

if(s == null){
%>
<p style="color:red;">Student not found.</p>
<%
}else{
%>

<% if(request.getAttribute("error")!=null){ %>
<p style="color:red;"><%=request.getAttribute("error")%></p>
<% } %>

<form action="students" method="post">

    <input type="hidden" name="action" value="update">
    <input type="hidden" name="id" value="<%=s.getId()%>">

    Roll No:
    <input type="text" name="rollNo" value="<%=s.getRollNo()%>" required><br><br>

    Name:
    <input type="text" name="name" value="<%=s.getName()%>" required><br><br>

    <input type="submit" value="Update Student">
</form>

<% } %>

<br>
<a href="students">Back</a>

</body>
</html>