<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<title>Save Event</title>

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Add Event</h2>
		</div>
	</div>

	<div id="container">
		<h3>Save Event</h3>

		<form:form action="saveEvent" modelAttribute="event" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />

			<table>
				<tbody>
					<tr>
						<td><label>Title:</label></td>
						<td><form:input path="title" /></td>
					</tr>

					<tr>
						<td><label>Date:</label></td>
						<td><form:input path="date" /></td>
					</tr>

					<tr>
						<td><label>Time:</label></td>
						<td><form:input path="time" /></td>
					</tr>
					<tr>
						<td><label>Place:</label></td>
						<td><form:input path="place" /></td>
					</tr>
					<tr>
						<td><label>Description:</label></td>
						<td><form:input path="description" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>


				</tbody>
			</table>


		</form:form>

		<div style=""></div>

		<p>
			<a href="${pageContext.request.contextPath}/event/showEvents">Back
				to List</a>
		</p>

	</div>

</body>

</html>










