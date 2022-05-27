package com.mscatalog.service;

import com.mscatalog.model.Category;
import com.mscatalog.model.dto.CategoryRequest;
import com.mscatalog.model.dto.CategoryResponse;
import com.mscatalog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public void createCategory(CategoryRequest categoryRequest) {
        Category category = Category.builder()
                .name(categoryRequest.getName())
                .active(categoryRequest.getActive())
                .build();

        categoryRepository.save(category);
        log.info("Category {} is saved", category.getCategory_id());
    }

    public List<CategoryResponse> getAllCategories() {

        List<Category> categories = categoryRepository.findAll();

       return categories.stream().map(this::mapToCategoryResponse).toList();
    }

    private CategoryResponse mapToCategoryResponse(Category category) {
        return CategoryResponse.builder()
                .category_id(category.getCategory_id())
                .name(category.getName())
                .active(category.getActive())
                .build();
    }

    public List<CategoryResponse> updateCategory(String category_id) {
    return (List<CategoryResponse>) this.categoryRepository
            .findByCategory_id(category_id)
            .orElseThrow(() -> new IllegalArgumentException("category doesn't exist"));

    }
    public List<CategoryResponse> updateCategory(String category_id, CategoryRequest categoryRequest) throws Exception{

        Optional<CategoryResponse> category = categoryRepository.findByCategory_id(category_id);
        if(category.isPresent()){
            CategoryResponse categoryUpdate = (CategoryResponse) category.get();

            categoryUpdate.setName(categoryRequest.getName());
            categoryUpdate.setActive(categoryRequest.getActive());
            //categoryRepository.save(categoryUpdate);


        }else {
            throw new IllegalArgumentException("id not found");
        }



      /*Optional<CategoryResponse> category = (Optional<CategoryResponse>) categoryRepository
              .findByCategory_id(category_id)
                .orElseThrow(() -> new IllegalArgumentException("id not found"));

        Category categories = Category.builder()
                .name(categoryRequest.getName())
                .active(categoryRequest.getActive())
                .build();

        return (List<CategoryResponse>) categories;
    */
        return null;
    }

    public ResponseEntity deleteCategoryById(String category_id){
        categoryRepository.deleteById(category_id);
        return null;
    }


}
