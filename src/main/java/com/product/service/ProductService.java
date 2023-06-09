package com.product.service;

import com.product.model.Product;
import com.product.model.ProductDetail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface ProductService {

    Product create(Product product);
    void insertDetail(ProductDetail detail);
    void insert(Product product);
    ArrayList<Product> getAll();
    void delete(int id);
    Product searchById(int id);

    Map<String, Objects> getProductDetail(int id);
    List<Product> findAllByName(String name);
}
