<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>${customerProfile.firstName}
	${customerProfile.lastName}'s Events</title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>${customerProfile.firstName}${customerProfile.lastName}'s
				Events</h2>

		</div>
	</div>
	<div id="container">

		<div id="content">

			<input type="button" value="Add Event"
				onclick="window.location.href='AddEventForm'; return false;"
				class="add-button" />


			<table>
				<tr>
					<th>Title</th>
					<th>Date</th>
					<th>Time</th>
					<th>Place</th>
					<th>Description</th>

				</tr>
				<!-- loop over and print our customers -->
				<c:forEach var="tempEvents" items="${events}">
					<tr>
						<td>${tempEvents.title}</td>
						<td>${tempEvents.date}</td>
						<td>${tempEvents.time}</td>
						<td>${tempEvents.place}</td>
						<td>${tempEvents.description}</td>


					</tr>

				</c:forEach>

			</table>

		</div>
	</div>

</body>
<br>
<br>
<br>
<br>
<br>
<br>
<a href="${pageContext.request.contextPath}/customer/list">Back to
	List</a>
</html>









