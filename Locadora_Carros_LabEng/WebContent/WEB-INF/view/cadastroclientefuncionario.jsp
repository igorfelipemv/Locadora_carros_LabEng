<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<c:url value="/novocliente" var="linkNovoCliente" />
	<c:url value="/buscacliente" var="linkBuscaCliente" />
	<c:url value="/rodarprocedure" var="linkRodarProcedure" />
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Locadora - Cadastro de Cliente</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<input type="hidden" name="chave_pagina" defaultValue="funcionario">
	
	<h1 style="text-align: center; color: black">Registro de Clientes</h1>
	
	<form action="${linkNovoCliente}" method="post">	
		<div class="form-group">
			<label>Nome: </label> <input type="text" name="nome">
		</div>
		
		<div class="form-group">
			<label>Sobrenome: </label> <input type="text" name="sobrenome">
		</div>
		
		<div class="form-group">
			<label>RG: </label> <input type="text" name="rg">
		</div>
		
		<div class="form-group">
			<label>CPF: </label> <input type="text" name="cpf">
		</div>
		
		<div class="form-group">
			<label>Telefone: </label> <input type="text" name="telefone">
		</div>
		
		<div class="form-inline">
			<button type="submit" class="btn btn-primary mb-2">Cadastrar</button>
		</div>
	</form>
	
	<form action="${linkBuscaCliente}" method="get">
		<div align="center">
			<label>Nome</label> <input type="text" name="nome">
		</div>
		
		<div align="center">
			<button type="submit" class="btn btn-primary mb-2">Buscar</button>
		</div>
		
		<div align="center">
			<label>${mensagem_de_retorno}</label>
		</div>
	</form>
	
	<div align="left">
		<label>${msg_retorno}</label>
	</div>
	<table style="margin-top: 20px" class="table">
		<thead class="thead-light">
			<tr>
				<th scope="col">Id</th>
				<th scope="col">Nome</th>
				<th scope="col">Sobrenome</th>
				<th scope="col">RG</th>
				<th scope="col">CPF</th>
				<th scope="col">Telefone</th>
				<th scope="col"></th>
				<th scope="col"></th>
			</tr>
		</thead>
		
		 <tbody>
			<c:forEach items="${listacliente}" var="cliente">
				<tr>
					<td>${cliente.id}</td>
					<td>${cliente.nome}</td>
					<td>${cliente.sobrenome}</td>
					<td>${cliente.rg}</td>
					<td>${cliente.cpf}</td>
					<td>${cliente.telefone}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

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