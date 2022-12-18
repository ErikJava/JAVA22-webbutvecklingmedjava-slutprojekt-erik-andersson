
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<jsp:useBean id="bg" class="model.BackgroundBean" />	
<%@page import="model.WeatherBean"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./views/style.css">
<meta charset="UTF-8">
<title>Weather</title>
</head>

<!-- The JavaBean that gets the color codes for background color -->
<body style="background: rgb(
<jsp:getProperty name="bg" property="r" />, 
<jsp:getProperty name="bg" property="g" />, 
<jsp:getProperty name="bg" property="b" />
)">

    <!-- The JavaBean that gets the information from your search -->
	<% 
	WeatherBean wBean = (WeatherBean) request.getAttribute("wBean"); 	
	out.print("The weather in " + wBean.getCityStr() + ", " + wBean.getCountryStr() + " is now " + wBean.getCloudsStr() + " with a temperature of " +wBean.getTempStr() + " ºC" + ". The last weather update was: " +wBean.getDateStr()); 
	%>
	
	<!-- The form that lets you search for the weather -->
	<form action="OWservlet" method="get">
	<br>
		City <input type="text" name="city">
		<br>
		Country <input type="text" name="country">
		<br>
		<br>
		<input type="submit" value="Show weather">
	</form>
	
	<br>
	
	<!-- Your search history -->
	<h2>Previous searches:</h2>
	
	<!-- Cookie that saves the city you previously searched for -->
    <h4>${cookie["city"].getValue()}</h4>
	
</body>
</html>