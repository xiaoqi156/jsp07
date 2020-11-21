package com.sc.mybatis.mybatis.bean;

/**
 * @program: jsp03
 * @description: ${description}
 * @author: 谢齐
 * @create: 2020-09-11 15:11
 **/
public class Cars {

    private int carId;
    private int goodsId;
    private String goodsName;
    private float goodsPrice;
    private String goodsImag;
    private  int goodsNum;
    private int userId;

    public Cars(int cars_id){

    }

    public Cars(int carId, int goodsId, String goodsName, float goodsPrice, String goodsImag, int goodsNum, int userId) {
        this.carId = carId;
        this.goodsId = goodsId;
        this.goodsName = goodsName;
        this.goodsPrice = goodsPrice;
        this.goodsImag = goodsImag;
        this.goodsNum = goodsNum;
        this.userId = userId;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(float goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsImag() {
        return goodsImag;
    }

    public void setGoodsImag(String goodsImag) {
        this.goodsImag = goodsImag;
    }

    public int getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(int goodsNum) {
        this.goodsNum = goodsNum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }


    @Override
    public String toString() {
        return "Cars{" +
                "carId=" + carId +
                ", goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", goodsPrice=" + goodsPrice +
                ", goodsImag='" + goodsImag + '\'' +
                ", goodsNum=" + goodsNum +
                ", userId=" + userId +
                '}';
    }
}
