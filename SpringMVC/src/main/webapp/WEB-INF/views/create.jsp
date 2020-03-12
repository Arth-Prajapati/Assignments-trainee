<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>create</title>
</head>
<body>
	<h2>Spring MVC Create, Read, Update and Delete (CRUD) Example</h2>	
<form action="create" method="post">
<pre>
    <strong>Create Here | <a href="./retrieve">Click for Retrieve</a></strong>
		
	Name: 	<input type="text" name="name" />
	
	ID: 	<input type="text" name="Id" />
	
	Course: <input type="text" name="course" />

	<input type="submit" value="Create" />
</pre>
</form>
${msg}
</body>
</html>