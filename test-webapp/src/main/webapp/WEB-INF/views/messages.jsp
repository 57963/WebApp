<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Messages</title>
		<style>
			body{
				font-family:"Arial";
				padding:10;
			}
			
			table, th, td{
   				border: 1px solid black;
  				border-collapse: collapse;
			}
			
			
		</style>
	</head>
	<body>
		<table>
			<tr>
				<th>From</th>
				<th>To</th>
				<th>Timestamp</th>
				<th width="100%">Content</th>
				<th>Read?</th>
			</tr>
			<c:forEach var="message" items="${messages}">
				<tr>
					<td>${message.from}</td>
					<td>${message.to}</td>
					<td>${message.timestamp}</td>
					<td>${message.content}</td>
					<td>${message.read}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>