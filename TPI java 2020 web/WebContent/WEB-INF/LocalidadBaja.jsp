<%@page import="java.util.LinkedList"%>
<%@page import="logic.CtrlLoc"%>
<%@page import="entities.Localidad"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>ABM Localidades</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->
<link rel="icon" type="image/png" href="images/icons/favicon.ico" />
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css"
	href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
<link rel="stylesheet" type="text/css" href="css/util.css">
<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
<%
String e = (String) request.getAttribute("estado");
%>
<%
String em = (String) request.getAttribute("errorMessage");
%>
<%
CtrlLoc ctrlLoc = new CtrlLoc();
LinkedList<Localidad> localidades = ctrlLoc.getLocalidades();
%>
</head>
<body>

	<div class="limiter">
				<a href="Signin" class="btn-flotante">↩</a>
		<%
		if ((e != null) && (e.equals("Error"))) {
		%>
		<div style="position: absolute;">
			<h2 class="text-center snack-err"><%=em%></h2>
		</div>
		<%
		} else if (e != null) {
		%>
		<div style="position: absolute;">
			<h2 class="text-center snack"><%=e%></h2>
		</div>
		<%
		}
		%>

		<div class="container-login100"
			style="background-image: url('images/cachorros.jpg');">
			<div class="wrap-login100 p-l-55 p-r-55 p-t-65 p-b-54">
				<form class="login100-form validate-form" action="localidaddelete"
					method="post">
					<span class="login100-form-title p-b-10"> AdoptAr </span> <span
						class="login100-form-subtitle p-b-20"> Mascotas felices en
						hogares felices! </span>

					<p class="text-center txt2 m-b-15">Baja de Localidad</p>

					<div class="wrap-input100 validate-input m-b-15"
						data-validate="Localidad requerida">
						<span class="label-input100">Localidad</span> <select
							class="input100" required name="localidad">
							<option value="">Elija localidad</option>
							<%
							for (Localidad loc : localidades) {
							%>
							<option value="<%=loc.getId()%>"><%=loc.getNombre()%></option>
							<%
							}
							%>
						</select> <span class="focus-input100" data-symbol="&#xf206;"></span>
					</div>


					<div class="container-login100-form-btn m-t-25">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn">Quitar</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div id="dropDownSelect1"></div>

	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
	<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
	<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>