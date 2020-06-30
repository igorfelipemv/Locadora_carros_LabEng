<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	
	<!-- Bootstrap CSS -->
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" 
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" 
	crossorigin="anonymous">
	
	<!-- SCRIPTS -->
	<script src="resources/angular.js"></script>
	<script src="resources/helper.js"></script>
	
</head>

<body ng-app="HelpApp">
	<h1>Locadora de Carros - FATEC</h1>
	
	<div ng-controller="IndexController as controller">
		<h5>{{controller.usuario}}</h5>
	</div>
</body>

</html>