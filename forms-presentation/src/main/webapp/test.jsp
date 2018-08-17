<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="entities.Personnel"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="assets/css/bootstrap.css">

<!-- Website CSS style -->
<link rel="stylesheet" type="text/css" href="resources/CSS/MyStyle.css">

<!-- Website Font style -->
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.2.0/css/all.css" integrity="sha384-hWVjflwFxL6sNzntih27bfxkr27PmbbK/iSvJ+a4+0owXq79v+lsFkW54bOGbiDQ" crossorigin="anonymous">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<title>IBM-TP</title>
<script type="text/javascript">
	function confirmer(url) {
		var rep = confirm("Voulez-vous bien supprimer ce collaborateur?");
		if (rep == true) {
			document.location = url;
		}
	}
</script>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<a class="navbar-brand" style="color: white; Font-Weight: Bold;"
			href="#"><img style="width: 50; height: 20px" alt=""
			src="http://files.sugarcrm.com/2000px-IBM_logo.svg_.png"></a>
		<ul class="nav navbar-nav">
			<li class="active"><a href="testServlet">Ressources</a></li>
			<li><a href="testServlet2">Projets</a></li>
		</ul>

	</nav>

	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title"></div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<center>Ajout / Modification d'une ressource</center>
					</div>
					<div class="panel-body">
						<form class="form-horizontal col-md-10 col-md-offset-1"
							method="post" action="testServlet">

							<div class="form-group">
								<div class="input-group">
									<input type="hidden" class="form-control" name="id" id="id"
										value="<c:out value='${model.idPersonnel }'/>"
										placeholder="Enter your Name" />
								</div>
							</div>

							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label">Nom</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-user fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="nom" id="nom"
											value="<c:out value='${model.nom }'/>"
											placeholder="Enter your Name" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="prenom" class="cols-sm-2 control-label">Prénom</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-user fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="prenom" id="prenom"
											value="<c:out value='${model.prenom }'/>"
											placeholder="Enter your lastname" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="refog" class="cols-sm-2 control-label">Réference</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-id-card fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="refog" id="refog"
											value="<c:out value='${model.refog }'/>"
											placeholder="Enter your refog" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="statut" class="cols-sm-2 control-label">Statut</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-user-tie fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="statut" id="statut"
											value="<c:out value='${model.statut }'/>"
											placeholder="Entrer your statut" />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="date" class="cols-sm-2 control-label">Date</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-calendar fa-lg" aria-hidden="true"></i></span> <input
											type="date" class="form-control" name="date"
											value="<c:out value='${model.date_integration }'/>" id="date"
											placeholder="Enter your Date " />
									</div>
								</div>
							</div>

							<div class="form-group">
								<label for="projet" class="cols-sm-2 control-label">Projet</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-suitcase fa-lg" aria-hidden="true"></i></span> <select
											class="form-control" name="projet" id="projet">
											<option disabled selected></option>
											<c:forEach items="${projets}" var="item">
												<option value="<c:out value='${item.idProjet }'/>"
													<c:forEach items="${item.personnel }" var="perso">
									      				<c:if test="${perso.idPersonnel == model.idPersonnel }">
										      				selected
										      			</c:if>
										      		</c:forEach>>
													<c:out value='${item.nom }' />
												</option>
											</c:forEach>
										</select>
									</div>
								</div>
							</div>


							<div class="form-group ">
								<div class="btn-toolbar">
								<button type="submit"
									class="btn btn-primary btn-lg pull-right" value="post"
									name="action">Enregistrer</button>
								<button class="btn btn-primary btn-lg pull-right"
									name="action">Reset</button>
								</div>
							</div>

							<div class="login-register"></div>
						</form>
					</div>
				</div>
				<hr />
				<div class="panel panel-primary">
					<div class="panel-heading">
						<center>Liste des ressources</center>
					</div>
					<div class="panel-body">
						<table class="table">
							<thead class="thead-dark">
								<th scope="col">#</th>
								<th scope="col">Nom</th>
								<th scope="col">Prénom</th>
								<th scope="col">Refog</th>
								<th scope="col">Statut</th>
								<th scope="col">Date d'intégration</th>
								<th scope="col">Projet</th>
								<th scope="col"></th>
								<th scope="col"></th>
							</thead>
							<tbody>
								<c:forEach items="${personnels}" var="item">
									<tr>
										<th scope="row"><c:out value="${item.idPersonnel}"
												escapeXml="false" /></th>
										<td><c:out value="${item.nom}" /></td>
										<td><c:out value="${item.prenom}" /></td>
										<td><c:out value="${item.refog}" /></td>
										<td><c:out value="${item.statut}" /></td>
										<td><c:out value="${item.date_integration }" /></td>
										<td><c:forEach items="${projets }" var="projet">
												<c:forEach items="${projet.personnel }" var="perso">
													<c:if test="${perso.idPersonnel == item.idPersonnel }">
														<c:out value="${projet.nom }" />
													</c:if>
												</c:forEach>
											</c:forEach></td>
										<td><a
											href="testServlet?action=edit&id=<c:out value='${item.idPersonnel}' />"><i
												class="glyphicon glyphicon-pencil"></i></a></td>
										<td><a
											href="javascript:confirmer('testServlet?action=delete&id=<c:out value='${item.idPersonnel}' />')"><i
												class="glyphicon glyphicon-remove"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>


			</div>
		</div>
	</div>

	<div></div>



	<script type="text/javascript" src="assets/js/bootstrap.js"></script>
</body>
</html>

