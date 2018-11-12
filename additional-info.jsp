<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Additional info about Customers</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Incesa App 3 - Spring MVC</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Customer Details</h3>

			<form:form action="saveCustomerDetails" modelAttribute="customerDetail" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />

			<table>
				<tbody>
				   
				   <tr>
						<td><label>Age:</label></td>
						<td><form:input path="age" /></td>
					</tr>
			
					<tr>
						<td><label>Faculty:</label></td>
						<td><form:input path="faculty" /></td>
					</tr>

					<tr>
						<td><label>Hobby:</label></td>
						<td><form:input path="hobby" /></td>
					</tr>
					<tr>
						Choose your profile picture
						<input type="file" name="image" path="image" size="40">			


					</tr>

					<tr>
						<td><label></label></td>
						
						<td><input type="submit" value="Save Details" class="save" /></td>
					</tr>




				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to List</a>
		</p>

	</div>

</body>

</html>


