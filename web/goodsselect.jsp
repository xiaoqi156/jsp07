<%@ page import="Goods" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/15
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
    <h1>欢迎，来到XX商城后台管理系统！</h1>
    <h2>商品管理</h2>
    <h3> <a href="goodsadd.jsp">添加商品</a> </h3>
    <table border="1">
        <tr>

            <th>商品编号</th>
            <th>商品图片</th>
            <th>商品名称</th>
            <th>商品价格</th>
            <th>购物数量</th>
            <th>库存数量</th>
            <th>操作</th>

        </tr>

        <c:forEach items="${requestScope.goodsList}" var="goods">
            <tr>
                <td>${goods.goodsId}</td>
                <td>
                    <a href="goodsdownload?name=upload/${goods.goodsImg}">
                        <img src="upload/${goods.goodsImg}" width="100px" height="80px">
                    </a>
                </td>

                <td>${goods.goodsName}</td>
                <td>${goods.goodsPrice}</td>
                <td>${goods.goodsNum}</td>
                <td>${goods.goodsStock}</td>

                <td>
                    <a href="goodsupdate.jsp?goodsId=${goods.goodsId}&goodsName=${goods.goodsName}&goodsPrice=${goods.goodsPrice}&goodsNum=${goods.goodsNum}&goodsStock=${goods.goodsStock}&goodsImg=${goods.goodsImg}">修改</a>&nbsp;/&nbsp;
                    <a href="goodsdelete?goodsId=${goods.goodsId}">删除</a>
                </td>

            </tr>

        </c:forEach>

    </table>

</center>

</body>
</html>
