package com.sc.mybatis.mybatis.dao;

import com.sc.mybatis.mybatis.bean.Goods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: jsp03
 * @description: ${description}
 * @author: 谢齐
 * @create: 2020-09-15 09:39
 **/
public class GoodsDao {
    public List<Goods> select(){

        List<Goods> goodsList = new ArrayList<>();

        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库注册成功");

            //String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
            String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功");

            String sql ="select * from goods";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet!=null&&resultSet.next()) {
                Goods goods = new Goods(resultSet.getInt("goods_id"),

                        resultSet.getString("goods_name"),
                        resultSet.getFloat("goods_price"),
                        resultSet.getString("goods_img"),
                        resultSet.getInt("goods_num"),
                        resultSet.getInt("goods_stock")
                );
                goodsList.add(goods);
            }

            System.out.println("查询所有商品成功");

            resultSet.close();
            preparedStatement.close();
            connection.close();
            System.out.println("关闭资源成功");

        } catch (Exception e) {
            System.out.println("查询所有商失败");
        }
        return  goodsList;
    }


    //添加
    public void add(Goods goods) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库注册成功");

            //String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
            String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接成功");

            String sql ="insert into goods values(null,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //4、给问号赋值
            preparedStatement.setString(1,goods.getGoodsName());
            preparedStatement.setFloat(2,goods.getGoodsPrice());
            preparedStatement.setString(3,goods.getGoodsImg());
            preparedStatement.setInt(4,goods.getGoodsNum());
            preparedStatement.setInt(5,goods.getGoodsStock());

            //5、通过编译陈述对象执行SQL语句
            preparedStatement.executeUpdate();
            System.out.println("添加商品成功！");

            preparedStatement.close();
            connection.close();
            System.out.println("关闭资源成功！");

        } catch (Exception e) {
            System.out.println("添加商品失败！");
            e.printStackTrace();
        }
    }



    //修改
    public void update(Goods goods) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库注册成功");

            //String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
            String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接Mysql数据库成功");

            String sql ="update goods set goods_name=?,goods_price=?,goods_img=?,goods_num=?,goods_stock=? where goods_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //4、给问号赋值
            preparedStatement.setString(1,goods.getGoodsName());
            preparedStatement.setFloat(2,goods.getGoodsPrice());
            preparedStatement.setString(3,goods.getGoodsImg());
            preparedStatement.setInt(4,goods.getGoodsNum());
            preparedStatement.setInt(5,goods.getGoodsStock());
            preparedStatement.setInt(6,goods.getGoodsId());


            //5、通过编译陈述对象执行SQL语句
            preparedStatement.executeUpdate();
            System.out.println("修改商品成功！");

            preparedStatement.close();
            connection.close();
            System.out.println("关闭资源成功！");

        } catch (Exception e) {
            System.out.println("修改商品失败！");
        }

    }



    //删除
    public void delete(int goodsId) {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("数据库注册成功");

            //String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
            String url = "jdbc:mysql://localhost:3306/db202001?useUnicode=true&characterEncoding=utf8";
            String username = "root";
            String password = "root";

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("连接Mysql数据库成功");

            String sql = "delete from goods where goods_id=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            //4、给问号赋值
            preparedStatement.setInt(1,goodsId);


            //5、通过编译陈述对象执行SQL语句
            preparedStatement.executeUpdate();
            System.out.println("删除商品成功！");

            preparedStatement.close();
            connection.close();
            System.out.println("关闭资源成功！");

        } catch (Exception e) {
            System.out.println("删除商品失败！");
        }

    }
}
