<!-- Add icon library -->
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css">



			<!-- need to associate this data with customer id -->
	<c:forEach var="tempCustomer" items="${customerProfile}">
		<div class="container">
  <div class="avatar-flip">
    <img src="<img src="data:image/jpeg;base64,${accPicture}" /> height="150" width="150">
    <img src="http://i1112.photobucket.com/albums/k497/animalsbeingdicks/abd-3-12-2015.gif~original" height="150" width="150">
  </div>
  <h2>${customerProfile.firstName} ${customerProfile.lastName}</h2>
  <h4>${customerProfile.email}</h4>
  
  <p>Age: ${customerDetail.age}</p>
  <p>Faculty: ${customerDetail.faculty}</p>
  <p>Hobby: ${customerDetail.hobby}</p>
 
			<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
</div>
	</c:forEach>
			