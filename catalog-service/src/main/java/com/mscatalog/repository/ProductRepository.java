package com.mscatalog.repository;

import com.mscatalog.model.Product;
import com.mscatalog.model.dto.ProductResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{'Product_id' : ?0 }")
    Optional<ProductResponse> findByProduct_id(String Product_id);
}
