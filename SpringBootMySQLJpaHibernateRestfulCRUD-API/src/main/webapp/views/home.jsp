<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>

	<div class="container">
		<div class="jumbotorn">
			<div class="card">
				  <h5 class="card-header">Products List</h5>
				  <div class="card-body">
				    <h5 class="card-title" align="center">Shopping Cart - List of Products Available</h5>
				    
				    
				    <table class="table table-dark table-hover table-bordered">
					  <thead>
					    <tr>
					      <th scope="col">Product ID</th>
					      <th scope="col">Product Name</th>
					      <th scope="col">Price</th>
					      <th scope="col">Quantity</th>
					      <th scope="col" class="text-center">Action</th>
					    </tr>
					  </thead>
					  <tbody>
					  <c:forEach var="temp" items="${products}">
					    <tr>
					    
					    <c:url var="updateLink" value="/updateProduct">
							<c:param name="productId" value="${temp.id }"></c:param>
						</c:url>

						<!-- Construct and "Delete link" with customer id, using jstl -->
						<c:url var="deleteLink" value="/deleteProduct">
							<c:param name="productId" value="${temp.id }"></c:param>
						</c:url>
					    
					      <td >${temp.id}</td>
					      <td>${temp.name}</td>
					      <td>${temp.price}</td>
					      <td>${temp.quantity}</td>
					      <td align="center">
					      	<a href="${updateLink}"><button type="button" class="btn btn-primary badge-pill" style="width:90px;">Update</button></a>  | 
					      	<a href="${deleteLink}" onclick="if(!(confirm('Are you sure you want to delete this product ?'))) return false"><button type="button" class="btn btn-danger badge-pill" style="width:90px;"> Delete</button></a>
					      </td>
					    </tr>
					  </c:forEach>
					  </tbody>
					</table>
				    <a href="/addProduct"><button type="button" class="btn btn-primary">Add Product</button></a>
				    <a href="/searchProductByName"><button type="button" class="btn btn-primary">Search Product By Name</button></a>
				    <a href="/searchProductById"><button type="button" class="btn btn-primary">Search Product By ID</button></a>
		
				  </div>
				</div>
		</div>
	</div>

</body>
</html>