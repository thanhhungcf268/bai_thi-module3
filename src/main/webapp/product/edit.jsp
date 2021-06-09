<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 6/9/2021
  Time: 8:40 AM
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
<form method="post">
    <div align="center">
        <h1>
            <c:if test="${message=='Success!'}">
                <p style="color: green"><c:out value="${message}"/></p>
            </c:if>
            <c:if test="${message=='Error!'}">
                <p style="color: red"><c:out value="${message}"/></p>
            </c:if>
        </h1>
        <tbody>
        <div hidden>
            <input id="id" class="form-control" type="text" name="id" value="${product.id}">
        </div>
        <div>
            <label>Name:</label>
            <input id="name" class="form-control" type="text" name="name" value="${product.name}">
        </div>
        <div>
            <label for="price">Price:</label>
            <input id="price" class="form-control" type="number" name="price" value="${product.price}">
        </div>
        <div>
            <label for="soL">soL:</label>
            <input id="soL" class="form-control" type="text" name="soL" value="${product.soL}">
        </div>
        <div>
            <label for="color">Color:</label>
            <input id="color" class="form-control" type="text" name="color" value="${product.color}">
        </div>
        <div>
            <label for="moTa">moTa:</label>
            <input id="moTa" class="form-control" type="text" name="moTa" value="${product.moTa}">
        </div>
        <div>
            <label for="category">Category</label>
            <select id="category" name="id_category">
                <c:forEach items="${category}" var="category">
                    <option value="${category.getId()}"><c:out value="${category.getCategory()}"/></option>
                </c:forEach>
            </select>
        </div>
        <td>
            <button style="background-color: green" class="btn btn-success">Edit</button>
        <td>
            <button style="background-color: #222222"><a href="/products">Back</a></button>
        </td>

        </tbody>
    </div>
</form>
</body>
</html>
