<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>University Enrollments</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>
	<h2>List of TestCases</h2>
	<h2>
		<a href="<c:url value='training'/>">Training</a>
	</h2>
	<select>
	<option value="Training">Training</option>
	<option value="Hub">Hub</option>
	<option value="InfoMgr">InfoMgr</option>
	</select>
	<table>
		<tr>
			<td>TC_ID</td>
			<td>Description</td>
		</tr>
		<tr>
			<td></td>
			<c:forEach items="${employees}" var="employee">
				<td style="width: 40px">${employee}</td>
			</c:forEach>
		</tr>
		<c:forEach var="innerList" items="${results}">
		<tr>
			<c:forEach var="obj" items="${innerList}">
				<td>${obj}</td>
			</c:forEach>
			</tr>
		</c:forEach>


		<%-- <c:forEach items="${TCIDs}" var="tcid">
			<tr>
				<c:forEach items="${results}" var="result">
				<td>${result}</td>
				</c:forEach>
			</tr>
		</c:forEach> --%>
		</tr>
	</table>
	<br />
</body>
</html>