<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>feedback inserted</title>
</head>
<body>

<h2>feedback submitted</h2>
you submitted:
${feedback} <br><br><br><br><br><br>

	<form action="index.jsp"><br><br>
		<!-- by default, this is 'get' request. or u can specify 'put' -->
		<input type="submit" value="return to main">
	</form>	


</body>
</html>