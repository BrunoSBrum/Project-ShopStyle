package com.mscatalog.repository;

import com.mscatalog.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category, Long> {


    @Query("{'category_id' : ?0 }")
    public Category findByCategory_id(Long category_id);
}
