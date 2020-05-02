<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>your result</title>
</head>
<body>
	<table class="table table-bordered">
		<tr>
			<td class="tg-b22t"><center><b>SCORE</b></center></td>
			<td class="tg-b22t"><center><b>${result}</b></center></td>			
		</tr>
			<tr>
			<td class="tg-b22t"><center><b>MAX SCORE</b></center></td>
			<td class="tg-b22t"><center><b>5</b></center></td>			
		</tr>
			<tr>
			<td class="tg-b22t"><center><b>PERCENTAGE</b></center></td>
			<td class="tg-b22t"><center><b>${percent}%</b></center></td>			
		</tr>
		
	</table>
	
	<form action="index.jsp"><br><br>
		<!-- by default, this is 'get' request. or u can specify 'put' -->
		<input type="submit" value="return to main">
	</form>	
</body>
</html>