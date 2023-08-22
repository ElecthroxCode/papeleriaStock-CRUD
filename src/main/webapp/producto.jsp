<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Stock de la papeleria</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="./css/styles.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">

</head>
<body>
	<div class="container main">
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">Papelería</a>
				<button class="navbar-toggler" type="button"
					data-bs-toggle="collapse" data-bs-target="#navbarNav"
					aria-controls="navbarNav" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav">
						<li class="nav-item"><a class="nav-link active "
							data-bs-toggle="modal" data-bs-target="#modal-info"
							aria-current="page" href="#">Información</a></li>


					</ul>
				</div>
			</div>
		</nav>
		<div class="section-stock px-3">
			<div class="row pt-5 pb-3">
				<div class="d-flex justify-content-center">
					<h1 class="text-center">Stock de Papelería</h1>
				</div>
			</div>
			<!-- add-section -->
			<form action="SproductoPapeleria" method="POST" id="idForm"
				onsubmit="return validationForm()">
				<div class="d-flex">
					<div class="col mb-3 me-2">
						<label for="article" class="form-label">Articulo </label> <input
							type="text" class="form-control" name="article" id="idArticle">

					</div>
					<div class="col mb-3 me-2">
						<label for="trademark" class="form-label">Marca</label> <input
							type="text" class="form-control" name="trademark"
							id="idTrademark">

					</div>
					<div class="col mb-3 me-2">
						<label for="price" class="form-label">Precio</label> <input
							type="text" class="form-control" name="price" id="idPrice">

					</div>
					<div class="mb-3 me-2">
						<label for="amount" class="form-label">Cantidad</label> <input
							type="text" class="form-control" name="amount" id="idAmount">

					</div>
					<div class="col mb-3 align-self-end">
						<button type="submit" class="btn btn-primary"
							data-bs-toggle="modal" data-bs-target="#modalAlert" name="btn"
							value="add">Agregar</button>
					</div>
				</div>
			</form>
			<!--table-stock -->

			<table class="table" id="idTable">
				<thead>
					<tr>
						<th scope="col">id</th>
						<th scope="col">Articulo</th>
						<th scope="col">Marca</th>
						<th scope="col">Precio</th>
						<th scope="col">Cantidad</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<tbody>


					<c:forEach var="producto" items="${lista}">
						<tr>
							<td>${producto.id}</td>
							<td>${producto.articulo}</td>
							<td>${producto.marca}</td>
							<td>$ ${producto.precio}</td>
							<td>${producto.cantidad}</td>

							<td><button data-bs-toggle="modal"
									data-bs-target="#modalDelete" data-bs-id="${producto.id}"
									data-bs-art="${producto.articulo}"
									data-bs-trad="${producto.marca}"
									data-bs-pri="${producto.precio}" class="btn btn-primary">
									<i class="bi bi-trash-fill"></i>
								</button> <a class="btn btn-primary edit" id="btnModal"
								data-bs-toggle="modal" data-bs-target="#editModal"
								data-bs-id="${producto.id}" data-bs-art="${producto.articulo}"
								data-bs-trad="${producto.marca}"
								data-bs-pri="${producto.precio}"
								data-bs-amo="${producto.cantidad}"> <i
									class="bi bi-pencil-square"></i>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- Modal Edit -->
		<div class="modal fade" id="editModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog modal-sm">
				<div class="modal-content">
					<form action="SproductoEdit" method="POST"
						onsubmit="return validationFormEdit()">
						<div class="modal-header">
							<h1 class="modal-title fs-5 id="exampleModalLabel">Modificar
								producto</h1>
							<button type="button" class="btn-close" data-bs-dismiss="modal"
								aria-label="Close"></button>
						</div>
						<div class="modal-body">

							<div class="container-modal">
								<div class="mb-3 me-2">
									<input type="hidden" class="form-control inputs-modal"
										name="idEdit">
								</div>
								<div class="col mb-3 me-2">
									<label for="article" class="form-label text-dark">Articulo
									</label> <input type="text" class="form-control inputs-modal"
										id="art-m" name="articleM">
								</div>
								<div class="col mb-3 me-2">
									<label for="trademark" class="form-label text-dark">Marca</label>
									<input type="text" class="form-control inputs-modal"
										id="trad-m" name="trademarkM">
								</div>
								<div class="col mb-3 me-2">
									<label for="price" class="form-label text-dark">Precio</label>
									<input type="text" class="form-control inputs-modal" id="pri-m"
										name="priceM">
								</div>
								<div class="mb-3 me-2">
									<label for="amount" class="form-label text-body">Cantidad</label>
									<input type="text" class="form-control inputs-modal" id="amo-m"
										name="amountM">
								</div>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary close-modal"
								data-bs-dismiss="modal">Cerrar</button>
							<button type="submit" class="btn btn-primary"
								data-bs-toggle="modal" data-bs-target="#modalAlert"
								name="btnSave" value="save">Guardar</button>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- Modal information -->

		<div class="modal fade" id="modal-info" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Información</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<p>Aplicación web que permite agregar, modificar y eliminar
							productos del stock de una papelería. Los productos contendrá un
							nombre, la marca, un precio y la cantidad. No se permitirá campos
							vacios.</p>
						<p>Las tecnologías utilizadas para su diseño fueron JSP,
							Servlet y Bootstrap.</p>

					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-primary"
							data-bs-dismiss="modal">Close</button>

					</div>
				</div>
			</div>
		</div>

		<!-- Modal Alert -->

		<div class="modal fade" id="modalAlert" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Aviso</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">
						<h6 id="info-alert"></h6>
						<div id="img-alert" class="text-center"></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Aceptar</button>

					</div>
				</div>
			</div>
		</div>


		<!-- Modal Delete -->

		<div class="modal fade" id="modalDelete" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Aviso</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<form  action="SproductoEdit" method="GET">
						<div class="modal-body">
							<input type="hidden" id="id-delete" name="idDelete" />
							<h6 id="h6-delete"></h6>
						</div>
						<div class="modal-footer">
							<button type="submit" class="btn btn-danger"
								data-bs-dismiss="modal">SÍ</button>
							<button type="button" class="btn btn-secondary close-modal"
								data-bs-dismiss="modal">NO</button>

						</div>
					</form>
				</div>
			</div>
		</div>

		<!-- footer -->
		<div class="card rounded-0">
			<div class="card-header"></div>
			<div class="card-body">
				<h5 class="card-title">
					<a class="navbar-brand" href="#idTable">Papelería/Demo Stock</a>
				</h5>
				<p class="card-text text-center text-dark">&copy; Copyright 2023
					Emmanuel Silano</p>

			</div>
		</div>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<script src="./js/scripts.js"></script>
</html>