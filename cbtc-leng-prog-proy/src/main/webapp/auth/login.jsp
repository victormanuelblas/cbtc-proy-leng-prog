<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inicio de Sesión</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css" />
</head>
<body>

	<div class="row">
		<div class="col"></div>
		<div style="width: 500px" >
		
			<div class="card mt-5" >
				<div class="card-body">
					<form action="auth?opcion=autenticar" method="post" >
						<div class="mb-3" >
							<label for="nombre" class="form-label" >Nombre de usuario</label>
							<input type="text" class="form-control" id="nombre" name="nombre" />
						</div>
						<div class="mb-3" >
							<label for="clave" class="form-label" >Contraseña</label>
							<input type="password" class="form-control" id="clave" name="clave" />
						</div>
						<button type="submit" class="btn btn-primary" >Ingresar</button>
					</form>
				</div>
			</div>
			
			<%
				if (request.getAttribute("error") != null) {
					String error = request.getAttribute("error").toString();
			%>
			<br />
			<div class="alert alert-danger" >
				<%= error %>
			</div>
			<%
				}
			%>
		</div>
		<div class="col"></div>
	</div>
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>