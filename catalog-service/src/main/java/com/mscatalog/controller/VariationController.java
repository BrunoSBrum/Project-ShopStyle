package com.mscatalog.controller;

import com.mscatalog.model.dto.VariationRequest;
import com.mscatalog.model.dto.VariationResponse;
import com.mscatalog.service.VariationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/variations")
public class VariationController {


    @Autowired
    private VariationService variationService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createVariation(@RequestBody VariationRequest variationRequest){
        variationService.createVariation(variationRequest);

    }
    @PutMapping("/{variation_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<VariationResponse> updateVariation(@PathVariable Long variation_id
            , @RequestBody VariationRequest variationRequest ){
        return this.variationService.updateVariation(variation_id, variationRequest);

    }

    @DeleteMapping("/{variation_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteVariation(@PathVariable Long variation_id){
        return this.variationService.deleteVariationById(variation_id);
    }
}
