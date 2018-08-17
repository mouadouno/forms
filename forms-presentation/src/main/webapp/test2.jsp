<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="entities.Projet"%>

<!DOCTYPE html>

<%
	String action = (String) request.getAttribute("action");
%>

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
		var rep = confirm("Voulez-vous bien supprimer ce Projet?");
		if (rep == true) {
			document.location = url;
		}
	}
</script>
<script>
	function foo() {

		if (document.location.href.indexOf('action=view') > -1) {
			$('#myModal').modal('show');
		}
	}
</script>
</head>
<body onload="foo()">
	<nav class="navbar navbar-inverse">
		<a class="navbar-brand" style="color: white;Font-Weight: Bold;" href="#"><img  style="width: 50;height: 20px" alt="" src="http://files.sugarcrm.com/2000px-IBM_logo.svg_.png"></a>
      <ul class="nav navbar-nav">
	      <li><a href="testServlet">Ressources</a></li>
	      <li class="active"><a href="testServlet2">Projets</a></li>
   	  </ul>

	</nav>

	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title">
					
				</div>
				<div class="panel panel-primary">
					<div class="panel-heading">
						<center>Ajout / Modification d'un projet</center>
					</div>
					<div class="panel-body">
						<form class="form-horizontal col-md-10 col-md-offset-1"
							method="post" action="testServlet2">

							<div class="form-group">
								<div class="input-group">
									<input type="hidden" class="form-control" name="id" id="id"
										value="<c:out value='${model.idProjet }'/>"
										placeholder="Enter your Name" />
								</div>
							</div>

							<div class="form-group">
								<label for="name" class="cols-sm-2 control-label">Project
									name</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-user fa" aria-hidden="true"></i></span> <input
											type="text" class="form-control" name="nom" id="nom"
											value="<c:out value='${model.nom }'/>"
											placeholder="Entrer le nom du projet" />
									</div>
								</div>
							</div>


							<div class="form-group">
								<label for="responsable" class="cols-sm-2 control-label">Responsable</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-user-tie fa" aria-hidden="true"></i></span>
											<select class="form-control" name="responsable" id="responsable" >
													<option disabled selected></option>
												<c:forEach items="${personnel }" var="item">
													<option value="<c:out value='${item.idPersonnel }'/>" <c:if test="${model.responsable.idPersonnel == item.idPersonnel }">selected</c:if>>
														<c:out value='${item.nom}'/> <c:out value='${item.prenom}'/>
													</option>
												</c:forEach>
											</select>
									</div>
								</div>
							</div>



							<div class="form-group">
								<label for="date" class="cols-sm-2 control-label">Date
									début</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-calendar fa-lg" aria-hidden="true"></i></span> <input
											type="date" class="form-control" name="date_debut"
											value="<c:out value='${model.date_debut }'/>" id="date"
											placeholder="Enter your start Date " />
									</div>
								</div>
							</div>
							<div class="form-group">
								<label for="date" class="cols-sm-2 control-label">Date
									Fin</label>
								<div class="cols-sm-10">
									<div class="input-group">
										<span class="input-group-addon"><i
											class="fa fa-calendar fa-lg" aria-hidden="true"></i></span> <input
											type="date" class="form-control" name="date_fin"
											value="<c:out value='${model.date_fin }'/>" id="date"
											placeholder="Enter your end Date " />
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
						<center>Liste des Projets</center>
					</div>
					<div class="panel-body">
						<table class="table">
							<thead class="thead-dark">
								<th scope="col">#</th>
								<th scope="col">Nom</th>
								<th scope="col">Responsable</th>
								<th scope="col">Date début</th>
								<th scope="col">Date fin</th>
								<th scope="col"></th>
								<th scope="col"></th>
								<th scope="col"></th>
							</thead>
							<tbody>
								<c:forEach items="${projects}" var="item">
									<tr>
										<th scope="row"><c:out value="${item.idProjet}"
												escapeXml="false" /></th>
										<td><c:out value="${item.nom} " /></td>
										<td><c:out value="${item.date_debut }" /></td>
										<td><c:out value="${item.date_fin }" /></td>
										<td><c:out value="${item.responsable.nom }" /> <c:out value="${item.responsable.prenom }" /></td>
										<td><a
											href="testServlet2?action=view&id=<c:out value='${item.idProjet}' />"><i
												class="glyphicon glyphicon-eye-open"></i></a></td>
										<td><a
											href="testServlet2?action=edit&id=<c:out value='${item.idProjet}' />"><i
												class="glyphicon glyphicon-pencil"></i></a></td>
										<td><a
											href="javascript:confirmer('testServlet2?action=delete&id=<c:out value='${item.idProjet}' />')"><i
												class="glyphicon glyphicon-remove"></i></a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>


						<!-- Modal -->
						<div id="myModal" class="modal fade" role="dialog">
							<div class="modal-dialog">

								<!-- Modal content-->
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal">&times;</button>
										<h4 class="modal-title"><center><b>Liste des ressources</b></center></h4>
									</div>
									<div class="modal-body">
										<table class="table">
											<thead class="thead-dark">
												<th scope="col">#</th>
												<th scope="col">Nom</th>
												<th scope="col">Prénom</th>
												<th scope="col">Refog</th>
												<th scope="col">Statut</th>
												<th scope="col">Date d'intégration</th>
											</thead>
											<tbody>
												<c:forEach items="${model.personnel}" var="item">
													<tr>
														<th scope="row"><c:out value="${item.idPersonnel}"
																escapeXml="false" /></th>
														<td><c:out value="${item.nom}" /></td>
														<td><c:out value="${item.prenom}" /></td>
														<td><c:out value="${item.refog}" /></td>
														<td><c:out value="${item.statut}" /></td>
														<td><c:out value="${item.date_integration }" /></td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Close</button>
									</div>
								</div>

							</div>
						</div>




					</div>
				</div>


			</div>
		</div>
	</div>

	<div></div>



	<script type="text/javascript" src="assets/js/bootstrap.js"></script>
</body>
</html>

