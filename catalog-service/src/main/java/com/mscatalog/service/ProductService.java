package com.mscatalog.service;

import com.mscatalog.model.Category;
import com.mscatalog.model.Product;
import com.mscatalog.model.dto.ProductRequest;
import com.mscatalog.model.dto.ProductResponse;
import com.mscatalog.repository.CategoryRepository;
import com.mscatalog.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;

    public Product createProduct(ProductRequest productRequest) {
        Boolean active = false;

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .active(productRequest.getActive())
                .category_ids(productRequest.getCategory_ids())
                .build();


        List<Category> category_id = product.getCategory_ids();
        active =  (categoryRepository.findByCategory_id(String.valueOf(category_id))).get().getActive();
        if(active){
            return productRepository.save(product);
        }else {
            throw new RuntimeException("category is not enabled");

        }

    }

    public List<ProductResponse> getAllProducts() {
        List<Product> product = productRepository.findAll();

        return product.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .category_ids(product.getCategory_ids().toString())
                .name(product.getName())
                .description(product.getDescription())
                .active(product.getActive())
                .build();
    }

    public ResponseEntity<?> deleteById(String product_id){
        productRepository.deleteById(product_id);
        return null;
    }

    public List<ProductResponse> updateProduct(String product_id, ProductRequest productRequest) {

        Optional<ProductResponse> product = productRepository.findByProduct_id(product_id);
        if(product.isPresent()){
            ProductResponse productUpdate = (ProductResponse) product.get();

            productUpdate.setName(productRequest.getName());
            productUpdate.setDescription(productRequest.getDescription());
            productUpdate.setActive(productRequest.getActive());
            productUpdate.setCategory_ids(productRequest.getCategory_ids().toString());
            //productRepository.save(productUpdate);


        }else {
            throw new IllegalArgumentException("id not found");
        }
        return null;
    }
}
