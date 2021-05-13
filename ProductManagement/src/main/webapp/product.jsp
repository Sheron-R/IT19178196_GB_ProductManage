<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.Product"%>
<%@page import="model.ProductsAPI"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product Management</title>
<link rel="stylesheet" href="Views/bootstrap.min.css">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Product.js"></script>
</head>

<body> 
	

<h1 class="font-weight-bolder" style="text-align:center" >Product Management</h1>

<div class="container"><div class="row"><div class="col-7"> 
<form id="formProduct" name="formProduct" method="post" action="product.jsp">

 <br>Product Name:
 <input id="productname" name="productname" type="text" 
 class="form-control form-control-sm">
 
 <br> Product Code:
 <input id="productcode" name="productcode" type="text" 
 class="form-control form-control-sm">
 
 <br> Product Quantity:
 <input id="productquantity" name="productquantity" type="text" 
 class="form-control form-control-sm">
 
 <br> Product Description:
 <input id="productdescription" name="productdescription" type="text" 
 class="form-control form-control-sm">
 
 <br> Product Price:
 <input id="productprice" name="productprice" type="text" 
 class="form-control form-control-sm">
 
 <br> Product Availability:
 <input id="productavailable" name="productavailable" type="text" 
 class="form-control form-control-sm">
  <br> 
 <input id="btnSave" name="btnSave" type="button" value="Save" 
 class="btn btn-primary">
 <input type="hidden" id="hidProductIDSave" 
 name="hidProductIDSave" value="">
</form>

<div id="alertSuccess" class="alert alert-success"></div>
<div id="alertError" class="alert alert-danger"></div>
<br><br>
<div id="divProductsGrid">
 <%
Product productObj = new Product(); 
out.print(productObj.readProducts()); 
 %>
</div>
</div> </div> </div> 
</body>
</html>

