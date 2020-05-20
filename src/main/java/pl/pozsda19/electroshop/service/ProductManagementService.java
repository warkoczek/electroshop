package pl.pozsda19.electroshop.service;

import org.springframework.stereotype.Service;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.domain.dto.ProductMapper;
import pl.pozsda19.electroshop.exception.DuplicateProductCodeException;
import pl.pozsda19.electroshop.exception.ProductNotFoundException;
import pl.pozsda19.electroshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;


@Service
public class ProductManagementService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductManagementService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper=productMapper;
    }
    public List<Product> showAllProducts(){
        return productRepository.findAll();
    }
    public Optional<Product> showProductByCode(String code){
        return productRepository.findByCode(code);
    }
    public boolean productExists(String code){
        return productRepository.existsByCode(code);
    }

    public Product createProduct(ProductEntityWriting toProductEntity){
        Product product = productMapper.writeProductEntity(toProductEntity);
        productRepository.save(product);
        return product;
    }

    public Product updateProduct(ProductEntityWriting productEntityWriting){
        Optional<Product> toUpdate = productRepository.findByCode(productEntityWriting.getCode());
        if(toUpdate.isEmpty()) {
            throw new ProductNotFoundException("Brak produktu o podanym kodzie");
        }
        productRepository.delete(toUpdate.get());
        Product productUpdate = productMapper.writeProductEntity(productEntityWriting);
        productRepository.save(productUpdate);
        return productUpdate;

    }




}
