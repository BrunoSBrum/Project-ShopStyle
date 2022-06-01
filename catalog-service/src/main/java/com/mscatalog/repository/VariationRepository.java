package com.mscatalog.repository;

import com.mscatalog.model.Variation;
import com.mscatalog.model.dto.VariationResponse;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VariationRepository extends MongoRepository<Variation, Long> {

    @Query("{'variation_id' : ?0 }")
    VariationResponse findByVariationId(long variation_id);
}
