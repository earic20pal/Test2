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
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
	<script>
		//bodyonload();
		function bodyonload() {

			$(document).ready(function() {
				$.ajax({
					type : "GET",
					url : "./?method=getAlltcIDs",
					datatype : "html",
					/* data: {category: $category.attr("selectedIndex") }, */
					success : function(data) {
						$("#TcID").html(data)
					}
				});
			});
		}

		function GetTcID() {
			
			var state = $('#module').val();
			var link = $(this).attr("href");
			$.ajax({
				url :'./getTcidsForSelectedModule',
				method : 'get',
				ContentType : 'text/plain',
				success : function(response) {
					var options = '';
					if (response != null) {
						$(response).each(
								function(index, value) {
									options = options + '<option>' + value
											+ '</option>';
								});
						$('#TcID').html(options);
					}
					$('#loading').html('');
				}
			});

		}
	</script>

	<h2>Add TC in DB</h2>
	
	<form method="post" modelAttribute="employee">
		<table>
			<tr>
			<td>
				<select name="module" id="module" onchange="GetTcID()">
					<c:forEach items="${listCategory}" var="category">
						<option value="${category}">${category}</option>
					</c:forEach>
				</select>
				</td>
				<td>
					<Select id="TcID" name="TcID"></Select>
				</td>
			</tr>
		</table>


		<!--  <input type="button" id="showpair" name="showpair" onclick=showdata()/>-->
		<div id="ShowPairs" />
	</form>
</body>
</html>