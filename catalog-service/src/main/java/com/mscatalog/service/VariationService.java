package com.mscatalog.service;

import com.mscatalog.model.Variation;
import com.mscatalog.model.dto.VariationRequest;
import com.mscatalog.model.dto.VariationResponse;
import com.mscatalog.repository.VariationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class VariationService {

    private final VariationRepository variationRepository;

    public void createVariation(VariationRequest variationRequest) {
        Variation variation = Variation.builder()
                .color(variationRequest.getColor())
                .size(variationRequest.getSize())
                .price(variationRequest.getPrice())
                .quantity(variationRequest.getQuantity())
                .build();

        variationRepository.save(variation);
        log.info("Variation {} is saved", variation.getVariation_id());

    }
    public List<VariationResponse> updateVariation(String variation_id, VariationRequest variationRequest){

        Optional<VariationResponse> variation = variationRepository.findByVariationId(variation_id);
        if(variation.isPresent()){
            VariationResponse variationUpdate = (VariationResponse) variation.get();

            variationUpdate.setColor(variationRequest.getColor());
            variationUpdate.setSize(variationRequest.getSize());
            variationUpdate.setQuantity(variationRequest.getQuantity());
            variationUpdate.setPrice(variationRequest.getPrice());
            //variationRepository.save(variationUpdate);


        }else {
            throw new IllegalArgumentException("id not found");
        }

        return null;
    }

    public ResponseEntity deleteVariationById(String variation_id){
        variationRepository.deleteById(variation_id);
        return null;
    }




}
