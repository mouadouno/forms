<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ page import="entities.Personnel" %>

<!DOCTYPE html>
<% Personnel P = (Personnel) request.getAttribute("personnel");%>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

<!-- Website CSS style -->
<link rel="stylesheet" type="text/css" href="resources/CSS/MyStyle.css">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<title>Admin</title>

</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title">
					<img  style="width: 150px;height: 75px" alt="" src="http://files.sugarcrm.com/2000px-IBM_logo.svg_.png">
					<hr />
				</div>
				<div class="main-login main-center">
					<form class="form-horizontal" method="post" action="testServlet">

						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label">Nom</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="name" id="name"
										placeholder="Enter your Name" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">Prénom</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-user fa"
										aria-hidden="true"></i></span> <input type="text"
										class="form-control" name="prenom" id="prenom"
										placeholder="Enter your lastname" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Réference</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-users fa" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="refog" id="refog"
										placeholder="Enter your refog" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Date</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-calendar fa-lg" aria-hidden="true"></i></span> <input
										type="text" class="form-control" name="date"
										id="date" placeholder="Enter your Date " />
								</div>
							</div>
						</div>


						<div class="form-group ">
							<button type="submit"
								class="btn btn-primary btn-lg  login-button">Enregistrer</button>
								</div>

						<div class="login-register"></div>
					</form>
					<div >
  							<nav aria-label="breadcrumb">
 								 <ol class="breadcrumb">
    								<li class="breadcrumb-item active" aria-current="page">Liste des Ressources</li>
  								</ol>
							</nav>
					</div>
					<div>
												
												
												
												
						
						<table class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">#</th>
      <th scope="col">Id</th>
      <th scope="col">Nom</th>
      <th scope="col">Prénom</th>
      <th scope="col">Refog</th>
      <th scope="col">Statut</th>
      <th scope="col">Date</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td><%=P.getIdPersonnel()%></td>
      <td><%=P.getNom()%></td>
      <td><%=P.getPrenom()%></td>
      <td><%=P.getRefog()%></td>
      <td><%=P.getStatut()%></td>
      <td><%=P.getDate_integration()%></td>
    </tr>
  </tbody>
</table>
</div>
<div>



</div>
					</p>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="assets/js/bootstrap.js"></script>
</body>
</html>

