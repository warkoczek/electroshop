package pl.pozsda19.electroshop.service;

import org.springframework.stereotype.Service;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.domain.dto.ProductMapper;
import pl.pozsda19.electroshop.exception.DuplicateProductCodeException;
import pl.pozsda19.electroshop.repository.ProductRepository;

import java.util.Optional;


@Service
public class ProductManagementService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductManagementService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper=productMapper;
    }
    public boolean productExists(String code){
        return productRepository.existsByCode(code);
    }

    public Product createProduct(ProductEntityWriting toProductEntity){

        Product product = productRepository
                .findByCode(toProductEntity.getCode()).orElse(productMapper.writeProductEntity(toProductEntity));

        productRepository.save(product);

        return product;
    }

    private void throwDuplicateProductCodeException(){
        throw new DuplicateProductCodeException("code reserved");
    }


}
