<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/9/2021
  Time: 9:17 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .form-control {
            background-color: #fff;
            /*display: block;*/
            border-radius: 4px;
            /*box-shadow: 0 1px 1px rgba(0, 0, 0, 0.075) inset;*/
            width: 100%;
            text-align: center;
            height: 30px;
        }
    </style>
</head>
<body>
<h1>
    <c:if test="${message=='Success!'}">
        <p style="color: green"><c:out value="${message}"/></p>
    </c:if>
    <c:if test="${message=='Error!'}">
        <p style="color: red"><c:out value="${message}"/></p>
    </c:if>
</h1>
<form method="post">
    <div class="form-group">
        <label for="name">Name</label>
        <input id="name" class="form-control" name="name" type="text">
    </div>
    <div>
        <label for="price">price</label>
        <input id="price" class="form-control" name="price" value="0" type="number">
    </div>
    <div>
        <label for="Quantity">Quantity</label>
        <input id="Quantity" class="form-control" name="soL" type="text">
    </div>
    <div>
        <label for="color">Color</label>
        <input id="color" class="form-control" name="color" type="text">
    </div>
    <div>
        <label for="Description">Description</label>
        <td><input id="Description" class="form-control" name="moTa" type="text"></td>
    </div>
    <div>
        <label for="category">Category</label>
        <td><select id="category" name="id_category" class="form-control">
            <c:forEach items="${category}" var="category">
                <option value="${category.getId()}"><c:out value="${category.getCategory()}"/></option>
            </c:forEach>
        </select></td>
    </div>
    <div>
        <td>
            <button style="background-color: green" type="submit">Create</button>
        </td>
        <td>
            <button style="background-color: #222222"><a href="/products">Back</a></button>
        </td>
    </div>
</form>
</body>
</html>
