<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Customers</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>Orders for ${customer.name}&nbsp;&nbsp;
			<a href="<c:url value="/customers/${customer.id}/order/add"/> " class="btn btn-info">Add New Order</a>
			<a href="<c:url value="/customers"/>" class="btn btn-info">Back to Customers List</a></h2>
		<table class="table table-striped">
			<tr>
				<th>Number</th>
				<th>Value</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${customer.orders}" var="order">
				<tr>
					<td>Order id: <c:out value="${order.id}" /></td>
					<td>Order value: <c:out value="100 Euro" /></td>
					<td><a href="<c:url value="/customers/${customer.id}/order/${order.id}/delete"/> " class="btn btn-info">View Products</a>
					<a href="<c:url value="/customers/${customer.id}/order/${order.id}/delete"/> " class="btn btn-info">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
