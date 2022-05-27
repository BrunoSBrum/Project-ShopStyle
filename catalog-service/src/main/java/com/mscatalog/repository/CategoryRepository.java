package com.mscatalog.repository;

import com.mscatalog.model.Category;
import com.mscatalog.model.dto.CategoryResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query("{'category_id' : ?0 }")
    Optional<CategoryResponse> findByCategory_id(String category_id);
}
