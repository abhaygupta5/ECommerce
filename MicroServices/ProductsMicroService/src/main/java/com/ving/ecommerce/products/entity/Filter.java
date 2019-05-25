package com.ving.ecommerce.products.entity;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Document(collection = "Filter")
public class Filter {
    private String category;
    private String subCategory;
    private HashMap<String, Object> filters;

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

    public HashMap<String, Object> getFilters() {
        return filters;
    }

    public void setFilters(HashMap<String, Object> filters) {
        this.filters = filters;
    }
}
