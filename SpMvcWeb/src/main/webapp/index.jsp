<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>welcome!</title>
</head>
<body>
	<h1>WELCOME</h1>
	<form action="feedback.htm"><br><br>
		<!-- by default, this is 'get' request. or u can specify 'put' -->
		<input type="submit" value="add feedback">
	</form>	
		<form action="viewFeedbacks"><br><br>
		<!-- by default, this is 'get' request. or u can specify 'put' -->
		<input type="submit" value="viewFeedbacks">
	</form>	
			
		<form action="addQuestion.htm"><br><br>
		<!-- by default, this is 'get' request. or u can specify 'put' -->
		<input type="submit" value="addQuestion">
	</form>	
			
		<form action="getQuestions"><br><br>
		<!-- by default, this is 'get' request. or u can specify 'put' -->
		<input type="submit" value="getQuestions">
	</form>	
		<form action="getTestQuestions"><br><br>
		<!-- by default, this is 'get' request. or u can specify 'put' -->
		<input type="submit" value="getTestQuestions">
	</form>	
		<form action="takeTest"><br><br>
		<!-- by default, this is 'get' request. or u can specify 'put' -->
		<input type="submit" value="takeTest">
	</form>
</body>
</html>