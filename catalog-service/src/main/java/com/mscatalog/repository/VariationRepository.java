package com.mscatalog.repository;

import com.mscatalog.model.Variation;
import com.mscatalog.model.dto.VariationResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VariationRepository extends MongoRepository<Variation, String> {

    @Query("{'variation_id' : ?0 }")
    Optional<VariationResponse> findByVariationId(String variation_id);
}
