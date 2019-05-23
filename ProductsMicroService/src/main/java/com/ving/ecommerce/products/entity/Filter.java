package com.ving.ecommerce.products.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Filter {
    private String category;
    private String subCategory;
    private Object filters;

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

    public Object getFilters() {
        return filters;
    }

    public void setFilters(Object filters) {
        this.filters = filters;
    }
}
