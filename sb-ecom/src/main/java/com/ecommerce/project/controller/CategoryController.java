package com.ecommerce.project.controller;

import com.ecommerce.project.model.Category;
import com.ecommerce.project.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

//    @GetMapping("api/public/categoryList")
    @RequestMapping(value = "public/categoryList", method = RequestMethod.GET) // method level
    private ResponseEntity<List<Category>> getAllCategories () {
        List<Category> categoryList = categoryService.getAllCategoryList();
//        return categoryService.getAllCategoryList();
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @PostMapping("public/categoryList")
    public ResponseEntity<String> createCategory(@RequestBody Category category) {
        categoryService.createCategory(category);
        return new ResponseEntity<>("Category created successfully", HttpStatus.CREATED);
    }

    @DeleteMapping("admin/categoryList/{categoryId}")
    public ResponseEntity<String> deleteCategory(@PathVariable Long categoryId) {
        try {
            String status = categoryService.deleteCategory(categoryId);
//            return new ResponseEntity<>(status, HttpStatus.OK);
            return ResponseEntity.status(HttpStatus.OK).body(status);
        }
        catch (ResponseStatusException e) {
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }

    @PutMapping("admin/categoryList/{categoryId}")
    public ResponseEntity<String> updateCategory(@RequestBody Category category,
                                                  @PathVariable Long categoryId) {

        try {
            Category status = categoryService.updateCategory(category, categoryId);
            return new ResponseEntity<>("Category with category Id: " + categoryId + " is updated", HttpStatus.OK);
        }
        catch (ResponseStatusException e){
            return new ResponseEntity<>(e.getReason(), e.getStatusCode());
        }
    }
}
