package com.lanou.service;

import com.lanou.entity.Product;

import java.util.List;
import java.util.Map;

/**
 * Created by han on 2018/4/3.
 */

public interface ProductService {
    public List<Product> findAllProducts();
    public Product findProductsByProductId(int id);
    public List<Product> findProductsLike(String productName);
    public  int findProductsLikeCount(String productName);
    public List<Product> findProductByKind(int productKind);

}

