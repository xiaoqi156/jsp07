package com.sc.mybatis.mybatis.servlet;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;
import com.sc.mybatis.mybatis.bean.Goods;
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
@WebServlet(urlPatterns = "/goodsadd")
public class GoodsAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(super.getServletConfig(),request,response);
        smartUpload.setAllowedFilesList("jpg,JPG,png,PNG,bmp,BMP,icon,ICON,gif,GIF");

        String goodsImg=null;
        try{
            smartUpload.upload();
            File file = smartUpload.getFiles().getFile(0);

            if(file.isMissing()){
                System.out.println("用户没选择文件！");
            }else {
                String path = request.getServletContext().getRealPath("upload");
                System.out.println("路径是:"+path);

                file.saveAs(path+"/"+file.getFileName());
                goodsImg = file.getFileName();
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("文件上传失败！");
        }


        Request req=smartUpload.getRequest();

        String goodsName = req.getParameter("goodsName");
        String goodsPriceStr = req.getParameter("goodsPrice");
        float goodsPrice = Float.parseFloat(goodsPriceStr);
        String goodsStockStr = req.getParameter("goodsStock");
        int goodsStock = Integer.parseInt(goodsStockStr);

        Goods goods = new Goods(0, goodsName, goodsPrice, goodsImg, 1, goodsStock);
        GoodsDao dao = new GoodsDao();
        dao.add(goods);

        response.sendRedirect("goodsselect");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
