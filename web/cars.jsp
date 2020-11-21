<%@ page import="java.util.List" %>
<%@ page import="Cars" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/11
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>购物车</title>
</head>

<body>
<center>
    <h1>欢迎，${sessionScope.userName},来XX商城购物！</h1>
    <h2>我的购物车</h2>
    <h3> <a href="main.jsp">继续购物</a> </h3>
    <table border="1">
        <tr>
            <th>编号</th>
            <th>商品编号</th>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>购物数量</th>
            <th>操作</th>
        </tr>

        <c:forEach items="${sessionScope.carsList}" var="cars">
            <tr>
                <td>${cars.carId}</td>
                <td>${cars.goodsId}</td>
                <td><img src="images/3.jpg" width="100px" height="80px"></td>
                <td>${cars.goodsName}</td>
                <td>${cars.goodsPrice}</td>
                <td>${cars.goodsNum}</td>
                <td></td>
            </tr>
        </c:forEach>

    </table>

</center>

</body>
</html>
