package com.sc.mybatis.mybatis.servlet;

import com.sc.mybatis.mybatis.bean.Goods;
import com.sc.mybatis.mybatis.dao.GoodsDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @program: jsp03
 * @description: ${description}
 * @author: 谢齐
 * @create: 2020-09-15 09:40
 **/
@WebServlet(urlPatterns = "/goodsselect")
public class GoodsSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("查询商品");
        GoodsDao dao = new GoodsDao();

        List<Goods> goodsList = dao.select();

        request.setAttribute("goodsList",goodsList);

        request.getRequestDispatcher("goodsselect.jsp").forward(request,response);

    }
}
