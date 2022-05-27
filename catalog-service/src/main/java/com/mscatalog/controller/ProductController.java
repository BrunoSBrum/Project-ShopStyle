package com.mscatalog.controller;

import com.mscatalog.model.dto.ProductRequest;
import com.mscatalog.model.dto.ProductResponse;
import com.mscatalog.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/v1/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts(){
        return productService.getAllProducts();

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);

    }

    @DeleteMapping("/{product_id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<?> deleteById(@PathVariable String product_id){
        return productService.deleteById(product_id);
    }

    @PutMapping("/{product_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<ProductResponse> updateProduct(@PathVariable String product_id
            , @RequestBody @Validated ProductRequest productRequest){
        return this.productService.updateProduct(product_id, productRequest);

    }


}
