<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:url value="/alteraanimal" var="linkAlteraAnimal" />
<c:url value="/novoanimal" var="linkNovoAnimal" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PetShop - Altera</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">
</head>
<body>
	<h1 style="text-align: center; color: blue">Alteração de Animais</h1>

	<form action="${linkAlteraAnimal}" method="post">
		<input type="hidden" name="id" value="${animal.id}">
		<div class="form-group">
			<label>Nome: </label> <input type="text" name="titulo"
				class="form-control" value="${animal.titulo}">
		</div>
		<div class="form-group">
			<label>Espécie: </label> 
			<select name="especie" class="form-control">
				<option value="Cachorro">Cachorro</option>
				<option value="Gato">Gato</option>
			</select>
		</div>
			<div class="form-group">
			<label>Serviço: </label> 
			<select name="servico" class="form-control">
				<option value="Banho">Banho</option>
				<option value="Tosa">Tosa</option>
				<option value="Ambos">Ambos</option>
			</select>
		</div>
		<div class="form-inline">
			<button style="margin-left: 50%" type="submit"
				class="btn btn-primary mb-2">Alterar</button>
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