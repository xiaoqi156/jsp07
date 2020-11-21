package com.sc.mybatis.mybatis.dao;

import com.sc.mybatis.mybatis.bean.Cars;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: jsp03
 * @description: ${description}
 * @author: 谢齐
 * @create: 2020-09-11 15:13
 **/
public class CarDao {
    public void add(Cars cars) {
        try {

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("数据库注册成功");

        //String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
        String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("连接成功");

        String sql ="insert into cars values(null,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);

        //4、给问号赋值
        preparedStatement.setInt(1,cars.getGoodsId());
        preparedStatement.setString(2,cars.getGoodsName());
        preparedStatement.setFloat(3,cars.getGoodsPrice());
        preparedStatement.setString(4,cars.getGoodsImag());
        preparedStatement.setInt(5,cars.getGoodsNum());
        preparedStatement.setInt(6,cars.getUserId());

        //5、通过编译陈述对象执行SQL语句
         preparedStatement.executeUpdate();
         System.out.println("添加购物车成功");

         preparedStatement.close();
         connection.close();
         System.out.println("关闭成功");

        } catch (Exception e) {
            System.out.println("添加购物车失败");
            e.printStackTrace();
        }
    }


    public List<Cars> select(int userId){

        List<Cars> carsList = new ArrayList<>();
        try {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("数据库注册成功");

        String url = "jdbc:mysql://localhost:3306/db202001";
        String username = "root";
        String password = "root";

        Connection connection = DriverManager.getConnection(url, username, password);
        System.out.println("连接成功");

        String sql ="select * from cars where user_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,userId);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet!=null&&resultSet.next()) {
            Cars cars = new Cars(resultSet.getInt("cars_id"),
                    resultSet.getInt("goods_id"),
                    resultSet.getString("goods_name"),
                    resultSet.getFloat("goods_price"),
                    resultSet.getString("goods_img"),
                    resultSet.getInt("goods_num"),
                    resultSet.getInt("user_id")
            );
            carsList.add(cars);
        }

            System.out.println("通过用户ID查找购物车商品成功");
            resultSet.close();
            preparedStatement.close();
            connection.close();
            System.out.println("关闭资源成功！");

        }catch (Exception e){
            System.out.println("通过用户ID查找购物车商品失败");
            e.printStackTrace();
        }

        return carsList;
    }

}
