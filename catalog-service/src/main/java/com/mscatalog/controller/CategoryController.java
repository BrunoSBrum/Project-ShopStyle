package com.mscatalog.controller;

import com.mscatalog.model.Category;
import com.mscatalog.model.dto.CategoryRequest;
import com.mscatalog.model.dto.CategoryResponse;
import com.mscatalog.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/categories")
@RestController
@RequiredArgsConstructor
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createCategory(@RequestBody @Validated CategoryRequest categoryRequest){
        categoryService.createCategory(categoryRequest);

    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryResponse> getAllCategories(){
        return this.categoryService.getAllCategories();
    }

    @GetMapping("/{category_id}/products")
    @ResponseStatus(HttpStatus.OK)
    public Category getCategoryForId(@PathVariable Long category_id){
        return this.categoryService.findCategory(category_id);
    }

    @PutMapping("/{category_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Category updateCategory(@PathVariable Long category_id
            , @RequestBody @Validated CategoryRequest categoryRequest) throws Exception {
        return this.categoryService.updateCategory(category_id, categoryRequest);
    }


    @DeleteMapping("/{category_id}")
    public ResponseEntity<?> delete(@PathVariable Long category_id){
       categoryService.deleteCategoryById(category_id);
       return ResponseEntity.ok().build();
    }




}
