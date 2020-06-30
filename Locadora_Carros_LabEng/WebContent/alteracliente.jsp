<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/alteracliente" var="linkAlteraCliente" />
<c:url value="/novocliente" var="linkNovoCliente" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locadora - Alteração de Cliente</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<h1 style="text-align: center; color: black">Alteração de Clientes</h1>

	<form action="${linkAlteraCliente}" method="post">
		
		<input type="hidden" name="id" value="${cliente.id}">
		
		<div class="form-group">
			<label>Nome: </label> <input type="text" name="nome" value="${cliente.nome}">
		</div>
		
		<div class="form-group">
			<label>Sobrenome: </label> <input type="text" name="sobrenome" value="${cliente.sobrenome}">
		</div>
		
		<div class="form-group">
			<label>RG: </label> <input type="text" name="rg" value="${cliente.rg}">
		</div>
		
		<div class="form-group">
			<label>CPF: </label> <input type="text" name="cpf" value="${cliente.cpf}">
		</div>
		
		<div class="form-group">
			<label>Telefone: </label> <input type="text" name="telefone" value="${cliente.telefone}">
		</div>
		
		<div class="form-inline">
			<button type="submit" class="btn btn-primary mb-2">Alterar</button>
		</div>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>
</body>
</html>