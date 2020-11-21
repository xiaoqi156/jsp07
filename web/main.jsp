<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/9/11
  Time: 15:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>主页面</title>
</head>

<body>

<c:set var="userId" value="2" scope="session"></c:set>
<c:set var="userName" value="张三" scope="session"></c:set>

<center>
    <h1>欢迎， ${sessionScope.userName}  ，来淘宝商城购物</h1>
    <h2>  商品列表 </h2>
    <h2><a href="goodsselect">  商品后台管理</a> </h2>

    <div>
        <div style="float: left; margin: 3px" >
            <img src="images/4.jpg" width="200px" height="300px"><br>
            <h3 style="color: red">¥100 </h3>
            <h4> 羽绒服 </h4>
            <h4> <a href="caradd?goodsId=1&goodsName=羽绒服&goodsPrice=100&goodsImg=4.jpg&goodsStock=700&goodsNum=1">加入购物车</a> </h4>
        </div>

        <div style="float: left;margin: 3px">
            <img src="images/2.jpg" width="200px" height="300px"><br>
            <h3 style="color: red">¥50 </h3>
            <h4> 牛仔裤 </h4>
            <h4> <a href="caradd?goodsId=2&goodsName=牛仔裤&goodsPrice=100&goodsImg=2.jpg&goodsStock=700&goodsNum=1">加入购物车</a> </h4>
        </div>

        <div style="float: left;margin: 3px">
            <img src="images/3.jpg" width="200px" height="300px"><br>
            <h3 style="color: red">¥80 </h3>
            <h4> 保暖鞋 </h4>
            <h4> <a href="caradd?goodsId=3&goodsName=保暖鞋&goodsPrice=100&goodsImg=3.jpg&goodsStock=700&goodsNum=1">加入购物车</a> </h4>
         </div>

        <div style="float: left;margin: 3px">
            <img src="images/1.jpg" width="200px" height="300px"><br>
            <h3 style="color: red">¥300 </h3>
            <h4> 裙子 </h4>
            <h4> <a href="caradd?goodsId=4&goodsName=裙子&goodsPrice=100&goodsImg=1.jpg&goodsStock=700&goodsNum=1">加入购物车</a> </h4>
        </div>

    </div>

</center>

</body>
</html>
