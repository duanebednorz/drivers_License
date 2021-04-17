<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Driver's License</title>
<link rel="stylesheet"
	href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
<script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
<script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">

		<div class="jumbotron">
			<h1>New License</h1>
		</div>
		<a href="/persons/new">New Person</a>
		<hr>
		<div class="row">
			<div class="col-sm-4">
				<form:form action="/license/create" method="post"
					modelAttribute="aLicense">
					<div class="form-group">
						<label>People:</label> <select name="person" class="form-control">
							<c:forEach items="${allPeople}" var="peeps">
								<option value="${peeps.id}">${peeps.first_name}
									${peeps.last_name}</option>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<label>Number:</label>
						<form:input path="number" class="form-control" />
						<form:errors path="number" class="text-danger" />
					</div>
					<div class="form-group">
						<label>State:</label>
						<form:input path="state" class="form-control" />
						<form:errors path="state" class="text-danger" />
					</div>
					<div class="form-group">
						<label>Expiration Date:</label>
						<form:input type="date" path="expiration_date"
							class="form-control" />
						<form:errors path="expiration_date" class="text-danger" />
					</div>
					<input type="submit" value="Add License" class="btn btn-primary" />
				</form:form>
			</div>

			<div class="form-group">
				<c:forEach items="${allPeople}" var="peeps">
					<tr>
						<p>
							<a href="/person/${peeps.id}/view">${peeps.first_name}
								${peeps.last_name}</a>
						</p>
					</tr>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>