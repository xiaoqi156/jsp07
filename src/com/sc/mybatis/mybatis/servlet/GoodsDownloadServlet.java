package com.sc.mybatis.mybatis.servlet;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Request;
import com.jspsmart.upload.SmartUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.file.Path;

/**
 * @program: jsp03
 * @description: ${description}
 * @author: 谢齐
 * @create: 2020-09-15 16:55
 **/
@WebServlet(urlPatterns = "/goodsdownload")
public class GoodsDownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        System.out.println("需要下载的文件路径："+name);

        SmartUpload smartUpload = new SmartUpload();
        smartUpload.initialize(super.getServletConfig(),request,response);

       smartUpload.setContentDisposition(null);
        try{
           smartUpload.downloadFile(name);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("文件下载失败！");
        }
    }
}
