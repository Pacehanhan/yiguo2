package com.lanou.service.impl;

import com.lanou.dao.ProductDao;
import com.lanou.entity.Product;
import com.lanou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by han on 2018/4/3.
 */
@Service("productService")
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductDao productDao;
    public List<Product> findAllProducts() {
        return productDao.findAllProducts();
    }


    public Product findProductsByProductId(int id) {
        return productDao.findProductsByProductId(id);
    }

    public List<Product> findProductsLike(String productName) {
        return productDao.findProductsLike(productName);
    }

    public int findProductsLikeCount(String productName) {
        return productDao.findProductsLikeCount(productName);
    }

    public List<Product> findProductByKind(int productKind) {
        return productDao.findProductByKind(productKind);
    }

}
