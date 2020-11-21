package com.sc.mybatis.mybatis.servlet;

import com.sc.mybatis.mybatis.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @program: jsp03
 * @description: ${description}
 * @author: 谢齐
 * @create: 2020-09-15 09:40
 **/
@WebServlet(urlPatterns = "/goodsdelete")
public class GoodsDeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsIdStr=request.getParameter("goodsId");
        int goodsId=Integer.parseInt(goodsIdStr);

        GoodsDao dao=new GoodsDao();
        dao.delete(goodsId);

        response.sendRedirect("goodsselect");
    }
}
