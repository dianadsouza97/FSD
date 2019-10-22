<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>
<form class="text-center border border-light p-5"
		action="mycontroller.do" method="post">

		<p class="h4 mb-4">Customer Registration.</p>


		<input type="text" class="form-control mb-4" placeholder="first name"
			name="fName"> <input type="text" class="form-control mb-4"
			placeholder="last Name" name="lName"> <input type="text"
			class="form-control mb-4" placeholder="email" name="email"> <input
			type="submit">


	</form>
</body>
</html>