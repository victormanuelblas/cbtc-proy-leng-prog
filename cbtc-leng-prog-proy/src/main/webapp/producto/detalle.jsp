
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entidades.Producto"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Producto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
</head>
<body>

	<%@ include file="/shared/navbar.jsp" %>

	<%
		Producto prod = (Producto)request.getAttribute("info");
		String tituloBoton = "";
		String tituloForm = "";
		
		if(prod.getProductoId() == 0){
			tituloBoton = "Grabar";
			tituloForm = "Producto nuevo";
		}else{
			tituloBoton = "Actualizar";
			tituloForm = "Actualizar producto";
		}
	%>
	<div class="container">
		<h3><%= tituloForm %></h3>
		<div class="row">
			<form id="formProd" action="producto?opcion=registrar" method="post">
				<input type="hidden" name="productoId" id="productoId" value="<%= prod.getProductoId() %>" />
				<div class="mb-3 row">
					<label for="categoria" class="col-sm-2 col-form-label">Categoría</label>
					<div class="col-sm-10">
						<select class="form-select" aria-label="Default select example" id="categoria" name="categoria">
						  <option value="0">—Seleccione—</option>
						  <option value="1" <%= prod.getCategoriaId() == 1 ? "selected" : "" %>>Gaseosas</option>
						  <option value="2" <%= prod.getCategoriaId() == 2 ? "selected" : "" %>>Cervezas</option>
						  <option value="3" <%= prod.getCategoriaId() == 3 ? "selected" : "" %>>Energizantes</option>
						</select>
					</div>
				</div>
				<div class="mb-3 row">
					<label for="codigo" class="col-sm-2 col-form-label">Código</label>
					<div class="col-sm-10">
						<input type="text" name="codigo" id="codigo" class="form-control" value="<%= prod.getCodigo() %>" />
					</div>
				</div>
				<div class="mb-3 row">
					<label for="nombre" class="col-sm-2 col-form-label">Nombre</label>
					<div class="col-sm-10">
						<input type="text" name="nombre" id="nombre" class="form-control" value="<%= prod.getNombre() %>" />
					</div>
				</div>
				<div class="mb-3 row">
					<label for="precio" class="col-sm-2 col-form-label">Precio</label>
					<div class="col-sm-10">
						<input type="number" name="precio" id="precio" class="form-control" value="<%= prod.getPrecio() %>" />
					</div>
				</div>
				<div class="mb-3 row">
					<label for="stockMin" class="col-sm-2 col-form-label">Stock mínimo</label>
					<div class="col-sm-10">
						<input type="number" name="stockMin" id="stockMin" class="form-control" value="<%= prod.getStockMin() %>" />
					</div>
				</div>
				<div class="mb-3 row">
					<label for="stockMin" class="col-sm-2 col-form-label">Stock máximo</label>
					<div class="col-sm-10">
						<input type="number" name="stockMax" id="stockMax" class="form-control" value="<%= prod.getStockMax() %>" />
					</div>
				</div>
				<button type="submit" class="btn btn-outline-primary" ><%=tituloBoton %></button>
			</form>
		</div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.5/dist/jquery.validate.min.js" ></script>
	
	<script type="text/javascript" >
		$(() => {
			
			$('#formCurso').validate({
				rules: {
					codigo: {
						required: true
					},
					nombre: {
						required: true,
						minlength: 5
					},
					ciclo: {
						min: 1,
						max: 6
					}
				},
				messages: {
					codigo: {
						required: 'El campo codigo es requerido'
					},
					nombre: {
						required: 'El campo nombre es requerido',
						minlength: 'El campo debe tener mínimo 5 caracteres'
					},
					ciclo: {
						min: 'El ciclo debe ser mayor o igual a 1',
						max: 'El ciclo debe ser menor o igual a 6'
					}
				}
			});
			
		});
	</script>
</body>
</html>