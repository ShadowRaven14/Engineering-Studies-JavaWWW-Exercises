<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>

<html>
<head>
    <title>Add new product</title>
    <link type="text/css"
          href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" />
</head>
<body>
<div class="container">
    <div class="row">
        <nav class="navbar navbar-default" role="navigation">
            <ul class="nav navbar-nav">
                <li><a href="<c:url value="/"/>">Home</a></li>
                <li><a href="<c:url value="/category/"/>">Category</a></li>
                <li><a href="<c:url value="/product/"/>">Product</a></li>
            </ul>
        </nav>
    </div>
</div>


<div class="container">
    <div class="row">
        <h1>Add new product</h1>

        <form:form action="addProductConfirm" method="post"
                   commandName="productBean">
            <div class="form-group">
                <label for="productName">Product Name</label>
                <form:input path="productName" id="productName" />
            </div>
            <div class="form-group">
                <label for="productStock">Stock</label>
                <form:input path="productStock" id="productStock" />
            </div>
            <div class="form-group">
                <label for="productPrice">Price</label>
                <form:input path="productPrice" id="productPrice" />
            </div>

            <div class="form-group">
                <label for="productDescription">Description</label>
                <form:textarea path="productDescription" id="productDescription" />
            </div>

            <div class="form-group">
                <label for="category">Category</label>
                <form:select path="category" items="${categories}"
                             itemLabel="categoryName" itemValue="categoryId">
                </form:select>
            </div>

            <div class="form-group">
                <br />
                <button type="submit" class="btn btn-default btn-success">Submit</button>
            </div>
        </form:form>
    </div>
</div>
</body>
</html>