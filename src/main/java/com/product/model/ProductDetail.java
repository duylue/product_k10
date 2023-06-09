package com.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "product_detail")
public class ProductDetail {
    @Id
    private int did;

    private int categoryId;
    private float price;
    private String producer;

    @Override
    public String toString() {
        return "ProductDetail{" +
                "did=" + did +
                ", categoryId=" + categoryId +
                ", price=" + price +
                ", producer='" + producer + '\'' +
                '}';
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public ProductDetail() {
    }

    public ProductDetail(int did, int categoryId, float price, String producer) {
        this.did = did;
        this.categoryId = categoryId;
        this.price = price;
        this.producer = producer;
    }
}
