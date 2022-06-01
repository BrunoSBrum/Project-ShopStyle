package com.mscatalog.service;

import com.mscatalog.model.Category;
import com.mscatalog.model.Product;
import com.mscatalog.model.dto.ProductRequest;
import com.mscatalog.repository.CategoryRepository;
import com.mscatalog.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class ProductService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private SequenceGeneratorServ sequenceGeneratorServ;

    public Product createProduct(ProductRequest productRequest) throws Exception {

        Product product = modelMapper.map(productRequest, Product.class);
        product.setProduct_id(sequenceGeneratorServ
                .getSeqName(Product.SEQUENCE_NAME));
        List<Long> category_ids = product.getCategory_ids();

        for (Long category_id : category_ids) {
            Category category = categoryRepository
                    .findByCategory_id(category_id);

            if (category.getActive()) {
                mongoTemplate.save(product);
                mongoTemplate.update(Category.class)
                        .matching(where("category_ids")
                                .is(category.getCategory_id()))
                                .apply(new Update().push("productList", product))
                                      .first();
            }
            if (category.getActive()) {
                return productRepository.save(product);
            } else {
                throw new Exception("category is not active");
            }
        }
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(long product_id, ProductRequest productRequest) {
        Product productSpecific = productRepository
                .findByProduct_id(product_id);

        Product product = modelMapper.map(productRequest, Product.class);
        product.setName(productSpecific.getName());
        product.setActive(productSpecific.getActive());
        product.setDescription(productSpecific.getDescription());
        product.setCategory_ids(productSpecific.getCategory_ids());
        product.setVariation(productSpecific.getVariation());

       return productRepository.save(product);
    }

    public ResponseEntity<?> deleteById(long product_id) {
        productRepository.deleteById(product_id);
        return null;
    }

    public Product getProductForId(Long product_id) {
        Product product;

        if (product_id != null) {
            product = productRepository
                    .findByProduct_id(product_id);
        } else {
            throw new RuntimeException("Incorrect id");

        }
        return product;
    }
}
