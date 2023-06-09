package com.product.service.impl;

import com.product.model.Product;
import com.product.model.ProductDetail;
import com.product.repo.ProductRepository;
import com.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void insertDetail(ProductDetail detail) {
        productRepository.insertDetail(detail.getDid(),
                detail.getPrice(),detail.getProducer()
        ,detail.getCategoryId());
    }

    @Override
    public Product create(Product product) {
      return   productRepository.save(product);
    }

    @Override
    public ArrayList<Product> getAll() {
        return (ArrayList<Product>) productRepository.findAll();
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Map<String, Objects> getProductDetail(int id) {
        return productRepository.getProductDetail(id);
    }

    @Override
    public void insert(Product product) {
        productRepository.insert(product.getPid(),product.getPname()
        ,product.getStatus());
    }

    @Override
    public Product searchById(int id) {
        return null;
    }

    @Override
    public List<Product> findAllByName(String name) {
        return null;
    }
}
