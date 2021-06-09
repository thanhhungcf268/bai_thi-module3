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
</head>
<body>
<h1><c:if test="${message!= null}">
    <p style="color: red"><c:out value="${message}"/></p>
</c:if></h1>
<form method="post">
    <table>
        <tr>
            <td>Name</td>
            <td><input name="name" type="text"></td>
        </tr>
        <tr>
            <td>price</td>
            <td><input name="price" type="text"></td>
        </tr>
        <tr>
            <td>Quantity</td>
            <td><input name="soL" type="text"></td>
        </tr>
        <tr>
            <td>Color</td>
            <td><input name="color" type="text"></td>
        </tr>
        <tr>
            <td>Description</td>
            <td><input name="moTa" type="text"></td>
        </tr>
        <tr>
            <td>Category</td>
            <td><select name="id_category" >
                <c:forEach items="${category}" var="category">
                    <option value="${category.getId()}"><c:out value="${category.getCategory()}"/></option>
                </c:forEach>
            </select></td>
        </tr>
        <tr>
            <td><button style="background-color: green" type="submit">Create</button></td>
            <td><button style="background-color: #222222"><a  href="/products">Back</a></button></td>
        </tr>
    </table>
</form>
</body>
</html>
