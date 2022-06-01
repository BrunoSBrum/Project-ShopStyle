package com.mscatalog.repository;

import com.mscatalog.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

    @Query("{'Product_id' : ?0 }")
    public Product findByProduct_id(long Product_id);
}
