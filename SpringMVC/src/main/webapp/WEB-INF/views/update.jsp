<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>update</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>
	<p><strong>Update Here | <a href="../retrieve">Click for Read</a></strong></p>
<form action="../update" method="post">
<pre>
<c:forEach var="student" items="${listStudent}">
		
Id:    	<input type="text" name="dispId" value="${student.studentid}" disabled="disabled"/>
		<input type="hidden" name="Id" value="${student.studentid}"/>			
Name:  	<input type="text" name="name" value="${student.studentname}" />
	    
Course:	<input type="text" name="course" value="${student.studentcourse}" />
		    
        <input type="submit" value="Update" />	
</c:forEach>	
</pre>
</form>
${msg}
</body>
</html>