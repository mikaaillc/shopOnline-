package com.example.shoponline.Service.Concrete;

import com.example.shoponline.Entities.Category;
import com.example.shoponline.Entities.Product;
import com.example.shoponline.Repository.CategoryRepository;
import com.example.shoponline.Service.Abstract.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    private CategoryRepository  categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Boolean saveCategory(Category category) {
        try {
            categoryRepository.save(category);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public List<Object> getCategoryData() {
        return categoryRepository.getCategoryData();
    }

    @Override
    public List<Category> getCategoriesByActive(boolean active) {
         return categoryRepository.getCategoriesByActive(active);
    }

    @Override
    public Category updateCategory(Long id, Category category) {
        Optional<Category> category1 = categoryRepository.findById(id);
        if(category1.isPresent()){
            Category foundCategory=category1.get();
            foundCategory.setCategoryName(category.getCategoryName());
            foundCategory.setActive(category.getActive());
            categoryRepository.save(foundCategory);
            return foundCategory;
        }else{
            return null;
        }

    }

}
