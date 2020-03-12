<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>retrieve</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
	<p><strong>Student List is Here | <a href="/SpringMVC/">Click for Create</a></strong></p>
	<table border="1">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Course</th>
			<th>Action</th>
		</tr>
		<c:forEach var="student" items="${listStudent}">
			<tr>
				<td>${student.studentid}</td>
				<td>${student.studentname}</td>
				<td>${student.studentcourse}</td>
				<td><a href="update/<c:out value='${student.studentid}'/>">Update</a> | <a
					href="delete/<c:out value='${student.studentid}'/>">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>