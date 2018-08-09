<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- JSTL --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- Spring security taglibs--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	$(document).ready(function(){
		
	    $("form").submit(function(){
	    	$('#loading').html('Loding your Result Please Wait.....');
	    });
	});
	
	function TestCaseData()
	{
		$.ajax({
			url:'./gotoAddTestDataPage',
			method : 'post',
			datatype : 'json'
			
			
		});
	}
		
		
	</script>

	<h2>Find Test Case Results</h2>
	<%-- <c:url var="home" value="/" scope="request" /> --%>
	<form method="post" action="${pageContext.request.contextPath}/list">
		<table>
			<tr>
				<td><select name="module" id="module">
						<c:forEach items="${listCategory}" var="category">
							<option value="${category}">${category}</option>
						</c:forEach>
				</select></td>
				<td><input type="submit" value="Redirect Page" /></td>
				<input type="button" name="modify"id="modify" onclick="TestCaseData()"/>
				<td><div id="loading"></div></td>
			</tr>
		</table>
	</form>
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
</body>
</html>