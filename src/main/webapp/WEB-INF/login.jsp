<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>
<body>

	<div class="container">
		<form class="form-horizontal" role="form" method="post">
			<div class="form-group">
				<label class="control-label col-sm-2" for="name">User:</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="user" name="user" value="">
				</div>
				<label class="control-label col-sm-2" for="name">Password:</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="password" name="password" value="">
				</div>
			</div>
			
			<c:if test="${not empty error}">
				<div class="alert alert-danger">Error: ${error}</div>
			</c:if>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button class="btn btn-primary">Login</button> 
				</div>
			</div>
		</form>
	</div>

</body>
</html>
