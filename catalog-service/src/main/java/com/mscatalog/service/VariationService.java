package com.mscatalog.service;

import com.mscatalog.model.Product;
import com.mscatalog.model.Variation;
import com.mscatalog.model.dto.VariationRequest;
import com.mscatalog.model.dto.VariationResponse;
import com.mscatalog.repository.ProductRepository;
import com.mscatalog.repository.VariationRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
@RequiredArgsConstructor
public class VariationService {

    private final VariationRepository variationRepository;
    private final SequenceGeneratorServ sequenceGeneratorServ;
    private final MongoTemplate mongoTemplate;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;


    public Variation createVariation(VariationRequest variationRequest) {
        Variation variation = new ModelMapper().map(variationRequest, Variation.class);
        variation.setVariation_id(sequenceGeneratorServ
                .getSeqName(Variation.SEQUENCE_NAME));
        Product product = productRepository.findByProduct_id(variationRequest.getProduct_id());
        if(product != null) {
            mongoTemplate.save(variation);
            mongoTemplate.update(Product.class)
                    .matching(where("product_id")
                            .is(product.getProduct_id()))
                    .apply(new Update().push("variationList", variation))
                    .first();
            return variationRepository.save(variation);
        }else {
            throw new RuntimeException("product does not exist");
        }
    }
    public List<VariationResponse> updateVariation(long variation_id, VariationRequest variationRequest){

        VariationResponse variationFilter = variationRepository
                .findByVariationId(variation_id);

        Variation variation = modelMapper.map(variationRequest, Variation.class);
        variation.setColor(variationFilter.getColor());
        variation.setPrice(variationFilter.getPrice());
        variation.setQuantity(variationFilter.getQuantity());
        variation.setSize(variationFilter.getSize());
        variation.setProduct_id((Product) variationFilter.getProduct_id());

        return (List<VariationResponse>) variationRepository.save(variation);

    }

    public ResponseEntity deleteVariationById(long variation_id){
        variationRepository.deleteById(variation_id);
        return null;
    }




}
