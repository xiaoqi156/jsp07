<%--
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
    <title>商品修改页面</title>
</head>
<body>
     <% request.setCharacterEncoding("utf-8"); %>
     ${requestScope.goodsId}
     ${requestScope.goodsName}
     ${requestScope.goodsPrice}
     ${requestScope.goodsNum}
     ${requestScope.goodsStock}
     ${requestScope.goodsImg}

     <center>
         <h1>修改商品</h1>
         <form action="goodsupdate" method="post" enctype="multipart/form-data">

             <input type="hidden" name="goodsId" value="${param.goodsId}">
             <input type="hidden" name="goodsNum" value="${param.goodsNum}">
             <input type="hidden" name="goodsImg" value="${param.goodsImg}">

             商品名称：<input type="text" name="goodsName" placeholder="请输入商品名称" value="${param.goodsName}"><br><br>
             商品价格：<input type="text" name="goodsPrice" placeholder="请输入商品价格" value="${param.goodsPrice}"><br><br>
             库存数量：<input type="text" name="goodsStock" placeholder="请输入库存数量" value="${param.goodsStock}"><br><br>
             商品图片：<input type="file" name="upload" placeholder="请选择商品图片" ><br><br>

             <input type="submit" value="提交" >

         </form>
     </center>

</body>
</html>
