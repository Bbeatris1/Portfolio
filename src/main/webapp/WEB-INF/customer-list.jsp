<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>Customers</title>
    <link rel="stylesheet"
		href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  </head>
 
  <body>
  	<div class="page-header">
  		<div class="pull-left">
  			Welcome ${user}! This is a list of all customers.
  			<a href="/logout" class="btn btn-primary">Logout</a>
  		</div>
  		<div class="clearfix"></div>
  	</div>
  	
    <c:forEach items="${customers}" var="customer">
    <div class="form-horizontal">
      <div class="form-group">
		  <label class="control-label col-sm-2">Customer:</label>
		  <div class="col-sm-10">
			<p class="form-control-static">
				<c:out value="${customer.name}" />
			</p>
		  </div>
	  </div>
      <div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
			    	<a href="<c:url value="/customers/${customer.id}/edit"/> " class="btn btn-primary">Edit</a>			 
					<a href="<c:url value="/customers/${customer.id}/orders"/> " class="btn btn-primary">View Orders</a>
				</div>
			</div>
		</div>
    </c:forEach>
 
  </body>
</html>


