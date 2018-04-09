package com.lanou.entity;

/**
 * Created by lanou on 2018/4/3.
 */
public class ShopCar {
   private  int productId;
   private  int productStatus;
   private  int userId;
   private int productNumber;
   private int shopCarId;

    @Override
    public String toString() {
        return "ShopCar{" +
                "productId=" + productId +
                ", productStatus=" + productStatus +
                ", userId=" + userId +
                ", productNumber=" + productNumber +
                ", shopCarId=" + shopCarId +
                '}';
    }

    public int getShopCarId() {
        return shopCarId;
    }

    public void setShopCarId(int shopCarId) {
        this.shopCarId = shopCarId;
    }

    public int getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(int productNumber) {
        this.productNumber = productNumber;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(int productStatus) {
        this.productStatus = productStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public ShopCar() {
        super();
    }

}
