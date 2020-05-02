<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>viewFeedback.jsp</title>
</head>
<body>
Viewing all feedbacks.....

${feedbacks } <br><br><br>

<form action="index.jsp"><br><br>
		<!-- by default, this is 'get' request. or u can specify 'put' -->
		<input type="submit" value="return to main">
	</form>	
</body>
</html>