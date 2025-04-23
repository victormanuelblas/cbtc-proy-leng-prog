<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entidades.Producto" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
</head>
<body>

	<%@include file="/shared/navbar.jsp" %>
	<div class="container">
		<h2>Almacén - Productos</h2>
		
		<div class="row">
			<div class="col" >
				<a href="producto?opcion=detalle" class="btn btn-sm btn-outline-success"><i class="bi bi-plus-circle-fill"></i> Nuevo</a>
			</div>
			<div style="width: 200px" >
				<% 
					String texto = "";
					if(request.getParameter("texto") != null) texto = request.getParameter("texto"); 
				%>
				<form id="formBuscar" action="producto" method="get">
					<input type="text" id="texto" name="texto" placeHolder="Buscar" value="<%= texto %>" />
				</form>			
			</div>	
		</div>
		
		<div class="row">
			<div class="table-responsive">
				<table class="table table-striped table-hover">
					<thead>
						<tr>
							<th>Código</th>
							<th>Nombre</th>
							<th>Categoría</th>
							<th>Precio</th>
							<th>Stock</th>
							<th>Stock Min.</th>
							<th>Stock Max.</th>
							<th>Situación</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
						<% 
							if (request.getAttribute("lista") != null) {
								ArrayList<Producto> lista = (ArrayList<Producto>)request.getAttribute("lista");	
								
								for (Producto prod : lista) {
						%>
						<tr>
							<td><%= prod.getCodigo() %></td>
							<td><%= prod.getNombre() %></td>
							<td><%= prod.getCategoria() %></td>
							<td><%= prod.getPrecio() %></td>
							<td><%= prod.getStock() %></td>
							<td><%= prod.getStockMin() %></td>
							<td><%= prod.getStockMax() %></td>
							<td><%= prod.getEstado() %></td>
							<td>
								<a href="producto?opcion=detalle&id=<%= prod.getProductoId() %>" class="btn btn-sm btn-primary" ><i class="bi bi-pencil"></i></a>
								<a href="producto?opcion=eliminar&id=<%= prod.getProductoId() %>" class="btn btn-sm btn-danger" ><i class="bi bi-trash3"></i></a>
								<a href="producto?opcion=stock&id=<%= prod.getProductoId() %>" class="btn btn-sm btn-success" ><i class="bi bi-arrow-left-right"></i></a>
								<a href="producto?opcion=kardex&id=<%= prod.getProductoId() %>" class="btn btn-sm btn-info" ><i class="bi bi-card-list"></i></a>
							</td>
						</tr>
						<% 
								}
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>