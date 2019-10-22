<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<style>
tbody.collapse.in {
	display: table-row-group;
}
</style>
</head>
<body>
	<br>
	<br>
	<input type="submit" onclick="window.location.href='addcust.jsp'"
		value="Add Customer">
	<br>
	<br>
	<div class="container">
		<h2>CRM-Customer Relationship Management</h2>
		<div>
			<form action="search.do">

				<input name="search" type="text" /> <input type="submit"
					value="search">
			</form>
		</div>
		<br>
		<div>
			Sort Firstname By:
			<form action="sort.do">
				<input type="submit" value="Ascending" name="sort"> <input
					type="submit" value="Descending" name="sort">
			</form>
		</div>


		<!--  <td><a class="btn btn-danger"href="delete.do?id=<c:out value="${tempCustomer.id}"/>">Delete</a></td>
     <td><a class="btn btn-danger"href="update.do?id=<c:out value="${tempCustomer.id}"/>">Update</a> </td>-->
		</tr>



		<table class="table table-responsive table-hover"
			class="table table-striped">
			<thead>
				<tr>
					<th>Firstname</th>
					<th>Lastname</th>
					<th>Email</th>
					<th>Delete</th>
					<th>Update</th>
				</tr>
			</thead>

			<c:forEach var="tempCustomer" items="${customers}">
				<c:url var="updateLink" value="update.do">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>

				<c:url var="deleteLink" value="delete.do">
					<c:param name="customerId" value="${tempCustomer.id}" />
				</c:url>
				<tbody>


					<tr class="clickable" data-toggle="collapse"
						data-target="#group-of-rows-1" aria-expanded="false"
						aria-controls="group-of-rows-1">

						<td>${tempCustomer.firstName}</td>
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td><a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a></td>
						<td>

							<button type="button" class="btn btn-primary"
								data-toggle="collapse" data-target="#demo">Update</button>
						</td>

					</tr>

				</tbody>
				<tbody id="group-of-rows-1" class="collapse">
					<tr>
						<td><label>First name:</label></td>
						<td><input name="firstName" type="text"
							value="${tempCustomer.firstName }" /></td>
					</tr>
					<tr>
						<td><label>Last name:</label></td>
						<td><input name="lastName" type="text"
							value="${tempCustomer.lastName}" /></td>
					</tr>
					<tr>
						<td><label>Email:</label></td>
						<td><input name="email" type="text"
							value="${tempCustomer.email}" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Update" class="save" /></td>
					</tr>

				</tbody>
			</c:forEach>
		</table>
</body>
</html>