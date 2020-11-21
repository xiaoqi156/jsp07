package com.sc.mybatis.mybatis.servlet;

import com.sc.mybatis.mybatis.bean.Cars;
import com.sc.mybatis.mybatis.dao.CarDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


/**
 * @program: jsp03
 * @description: ${description}
 * @author: 谢齐
 * @create: 2020-09-11 15:53
 **/
@WebServlet(urlPatterns = "/caradd")
public class    CarAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");


        //String goodsIdStr = "4";
        String goodsIdStr = request.getParameter("goodsId");//给goodsId 加 Str 是区别于 整型goodsId，而goodsIdStr是要定义成 字符串类型的
        int goodsId = Integer.parseInt(goodsIdStr);//parseInt将字符串转换成整数

        String goodsName = request.getParameter("goodsName");

        String goodsPriceStr = request.getParameter("goodsPrice");
        float goodsPrice = Float.parseFloat(goodsPriceStr);

        String goodsImg = request.getParameter("goodsImg");

        String goodsNumStr = request.getParameter("goodsNum");
        int goodsNum = Integer.parseInt(goodsNumStr);

        String goodsStockStr = request.getParameter("goodsStock");
        int goodsStock = Integer.parseInt(goodsStockStr);


        HttpSession session = request.getSession();
        String userIdStr=(String)session.getAttribute("userId");
        int userId =Integer.parseInt(userIdStr);
        Cars cars = new Cars(0, goodsId, goodsName, goodsPrice, goodsImg, goodsNum, userId);

        System.out.println(cars);

        CarDao dao = new CarDao();
        dao.add(cars);

        List<Cars> carsList = dao.select(userId);

        session.setAttribute("carsList",carsList);
        response.sendRedirect("cars.jsp");

    }
}
