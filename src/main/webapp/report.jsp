<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Attendance Report</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

<div class="container">

<h2>Attendance Report</h2>

<table>
<tr>
<th>Roll</th>
<th>Name</th>
<th>Subject</th>
<th>Date</th>
<th>Status</th>
</tr>

<%
List<String[]> list = (List<String[]>)request.getAttribute("report");

if(list!=null){
for(String[] row : list){
%>
<tr>
<td><%=row[0]%></td>
<td><%=row[1]%></td>
<td><%=row[2]%></td>
<td><%=row[3]%></td>
<td><%=row[4]%></td>
</tr>
<% }} %>

</table>

<br>
<a href="dashboard.jsp">⬅ Back to Dashboard</a>

</div>

</body>
</html>