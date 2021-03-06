<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Automation Reports</title>

<style>
tr:first-child {
	font-weight: bold;
	background-color: #C6C9C4;
}
</style>

</head>


<body>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
		$(document).ready(function() {

			$("form").submit(function() {
				$('#loading').html('Loding your Result Please Wait.....');
			});
		});
	</script>
	<h2>List of TestCases Result</h2>
	<form method="post" action="${pageContext.request.contextPath}/list">
		<table>
			<tr>
				<td><select id="module" name="module">
						<option value="admin">Admin</option>
						<option value="thehub">Hub</option>
						<option value="infomgr">InfoMgr</option>
						<option value="training">Training</option>
						<option value="finance">Finance</option>
						<option value="sales">Sales</option>
						<option value="support">Support</option>
						<option value="opener">Opener</option>
						<option value="crm">CRM</option>
				</select></td>
				<td><input type="submit" value="Redirect Page" /></td>
				<td>
					<div id="loading"></div>
				</td>
			</tr>
		</table>
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
						<c:if test="${obj eq 'FAIL'}">
							<td style="color: red;">${obj}</td>
						</c:if>
						<c:if test="${obj eq 'PASS'}">
							<td style="color: green;">${obj}</td>
						</c:if>
						<c:if test="${obj eq 'N/A'}">
							<td style="color: #4d2600">${obj}</td>
						</c:if>
						<c:if
							test="${(obj ne 'FAIL') && (obj ne 'PASS') && (obj ne 'N/A')}">
							<td style="color: black;">${obj}</td>
						</c:if>


					</c:forEach>
				</tr>
			</c:forEach>

			</tr>
		</table>
	</form>
	<br />
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</body>
</html>