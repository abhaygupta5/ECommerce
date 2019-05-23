package com.ving.ecommerce.products.entity;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

@Document
public class Product {
    @Id
    private int productId;
    private String category;
    private String subCategory;
    private Object productImages;
    private String productName;
    private String brand;
    private double price;
    private Object attributes;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    public Object getProductImages() {
        return productImages;
    }

    public void setProductImages(String productImages) {
        this.productImages = productImages;
    }

    public void setProductImages(ArrayList<String> productImages) {
        this.productImages = productImages;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Object getAttributes() {
        return attributes;
    }

    // data field can be a string
    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }
    // data field can be a {}
    public void setAttributes(JSONObject attributes) {
        this.attributes = new BasicDBObject(attributes.toMap());
    }
    // data can be a []
    public void setAttributes(JSONArray attributes) {
        BasicDBList list = new BasicDBList();
        list.addAll(attributes.toList());
        this.attributes = list;
    }
}
