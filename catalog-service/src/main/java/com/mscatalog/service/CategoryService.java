package com.mscatalog.service;

import com.mscatalog.model.Category;
import com.mscatalog.model.dto.CategoryRequest;
import com.mscatalog.model.dto.CategoryResponse;
import com.mscatalog.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private SequenceGeneratorServ sequenceGeneratorServ;
    @Autowired
    private ModelMapper modelMapper;

    public void createCategory(CategoryRequest categoryRequest) {
        Category category = Category.builder()
                .name(categoryRequest.getName())
                .active(categoryRequest.getActive())
                .build();

        categoryRepository.save(category);
    }

    public List<CategoryResponse> getAllCategories() {

        List<CategoryResponse> categories = new ArrayList<>();
                categoryRepository.findAll()
                .forEach(category -> {
                    CategoryResponse catResp = modelMapper
                            .map(category, CategoryResponse.class);
                    categories.add(catResp);

                });

       return categories;
    }

    public Category findCategory(long category_id) {
        Category category = categoryRepository.findByCategory_id(category_id);
        if(category != null ){
            return category;
        }else throw new RuntimeException("category not found");
    }

    public Category updateCategory(Long category_id, CategoryRequest categoryRequest) {

        Category catUpdate = categoryRepository.findByCategory_id(category_id);

            catUpdate.setName(categoryRequest.getName());
            catUpdate.setActive(categoryRequest.getActive());

        return categoryRepository.save(catUpdate);

    }


    public ResponseEntity<?> deleteCategoryById(Long category_id){
        categoryRepository.deleteById(category_id);
        return null;
    }



}
