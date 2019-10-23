<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="p" class="com.mycompany.model.President" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="p"/>
President Name:<%= p.getPresidentName() %>
Age:<%= p.getAge() %>
<jsp:include page="mycontroller.do"></jsp:include>
</body>
</html>