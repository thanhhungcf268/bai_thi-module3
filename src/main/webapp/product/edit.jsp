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
</head>
<body>
<form method="post">
    <div align="center">
        <h1><c:if test="${message!= null}">
            <p style="color: red"><c:out value="${message}"/></p>
        </c:if></h1>
        <table class="table">
            <thead class="thead-light">
            <tr>
                <th style="text-align: right" scope="col">Property</th>
                <th scope="col">Data</th>
            </tr>
            </thead>
            <tbody>
            <tr hidden>
                <td style="text-align: right">User Id:</td>
                <td><input type="text" name="id" value="${product.id}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Name:</td>
                <td><input type="text" name="name" value="${product.name}"></td>
            </tr>
            <tr>
                <td style="text-align: right">Price:</td>
                <td>
                    <input type="text" name="price" value="${product.price}">
                </td>
            </tr>
            <tr>
                <td style="text-align: right">soL:</td>
                <td>
                    <input type="text" name="soL" value="${product.soL}">
                </td>
            </tr>
            <tr>
                <td style="text-align: right">Color:</td>
                <td>
                    <input type="text" name="color" value="${product.color}">
                </td>
            </tr>
            <tr>
                <td style="text-align: right">moTa:</td>
                <td>
                    <input type="text" name="moTa" value="${product.moTa}">
                </td>
            </tr>
            <td>Category</td>
            <td><select name="id_category">
                <c:forEach items="${category}" var="category">
                    <option value="${category.getId()}"><c:out value="${category.getCategory()}"/></option>
                </c:forEach>
            </select></td>
            <td>
                <button  style="width: 100px; height: 50px;background-color: green" class="btn btn-success">Edit</button>
            <td>
                <button style="background-color: #222222"><a href="/products">Back</a></button>
            </td>

            </td>
            </tr>
            </tbody>
        </table>
    </div>
</form>
</body>
</html>
