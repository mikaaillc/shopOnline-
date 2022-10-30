package com.example.shoponline.Service.Abstract;

import com.example.shoponline.Entities.Category;

import java.util.List;

public interface ICategoryService {

    List<Category> getAllCategory();
    Boolean saveCategory(Category category);
    List<Object> getCategoryData();

    List<Category> getCategoriesByActive(boolean active);

    Category updateCategory(Long id, Category category);
}
