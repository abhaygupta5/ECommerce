package com.ving.ecommerce.products.model;

import java.util.HashMap;

public class FilterDTO {
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

    @Override
    public String toString() {
        return "FilterDTO{" +
                "category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", filters=" + filters +
                '}';
    }
}
