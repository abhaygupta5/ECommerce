package com.ving.ecommerce.products.model;

public class FilterDTO {
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

    @Override
    public String toString() {
        return "FilterDTO{" +
                "category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                ", filters=" + filters +
                '}';
    }
}
