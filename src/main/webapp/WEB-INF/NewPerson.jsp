<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Driver's License</title>
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
  <div class="container">
    
    <div class = "jumbotron">
    <h1>New Person</h1>
    </div>
    <hr>
    <a href ="/licenses/new">New License</a>
    <hr>
    <div class="row">
			<div class="col-sm-4">
				<form:form action="/person/create" method="post" modelAttribute="aPerson">
					<div class="form-group">
						<label>First Name:</label>
						<form:input path="first_name" class="form-control" />
						<form:errors path="first_name" class="text-danger" />
					</div>
					<div class="form-group">
						<label>Last Name:</label>
						<form:input path="last_name" class="form-control" />
						<form:errors path="last_name" class="text-danger" />
					</div>
					<input type="submit" value="Add Person" class="btn btn-primary" />
				</form:form>
			</div>
		</div>
  </div>
</body>
</html>