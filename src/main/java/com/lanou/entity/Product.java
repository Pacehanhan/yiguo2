package com.lanou.entity;

/**
 * Created by han on 2018/4/3.
 */
public class Product {
    private int productId;  // 商品id
    private int productKind;  // 商品种类的序列号
    private  String productKindName; // 商品种类对应的商品种类名称
    private String productName;
    private  int productPrice;
    private  String productMsg; // 商品介绍信息
    private  String productUrl; // 商品图像

    public Product() {
    }

    public String getProductUrl() {
        return productUrl;
    }

    public void setProductUrl(String productUrl) {
        this.productUrl = productUrl;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductKind() {
        return productKind;
    }

    public void setProductKind(int productKind) {
        this.productKind = productKind;
    }

    public String getProductKindName() {
        return productKindName;
    }

    public void setProductKindName(String productKindName) {
        this.productKindName = productKindName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductMsg() {
        return productMsg;
    }

    public void setProductMsg(String productMsg) {
        this.productMsg = productMsg;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productKind=" + productKind +
                ", productKindName='" + productKindName + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productMsg='" + productMsg + '\'' +
                ", productUrl='" + productUrl + '\'' +
                '}';
    }
}
