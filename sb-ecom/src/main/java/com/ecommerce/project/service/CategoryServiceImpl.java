package com.ecommerce.project.service;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{

//    private List<Category> categoryList = new ArrayList<>();
    private Long nextId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllCategoryList() {
//        return categoryList;
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(nextId++);
//        return categoryList.add(category);
        categoryRepository.save(category);
    }

//    @Override
//    public String deleteCategory(Long categoryId) {
//        List<Category> categoryList = categoryRepository.findAll();
//
//        Category category = categoryList.stream()
//                .filter(c -> c.getCategoryId() == categoryId)
//                .findFirst()
//                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
//
//        if(category == null) {
//            return "Category not found";
//        }
//
//        categoryRepository.delete(category);
//        return "Category with categoryId: " + categoryId + " deleted successfully";
//    }

    @Override
    public String deleteCategory(Long categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found"));

        categoryRepository.delete(category);
        return "Category with categoryId: " + categoryId + " deleted successfully";
    }

//    @Override
//    public Category updateCategory(Category category, Long categoryId) {
//        List<Category> categoryList = categoryRepository.findAll();
//
//        Optional<Category> optionalCategory = categoryList.stream()
//                .filter(c -> c.getCategoryId() == categoryId)
//                .findFirst();
//
//        if (optionalCategory.isPresent()) {
//            Category existingCategory = optionalCategory.get();
//            existingCategory.setCategoryName(category.getCategoryName());
//            Category savedCategory = categoryRepository.save(existingCategory);
//
//            return savedCategory;
//        }
//        else {
//            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found");
//        }
//    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {

        Category savedCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category Not Found"));

        category.setCategoryId(categoryId);
        savedCategory = categoryRepository.save(category);

        return savedCategory;
    }
}
