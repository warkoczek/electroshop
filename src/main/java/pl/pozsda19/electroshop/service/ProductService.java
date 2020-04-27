package pl.pozsda19.electroshop.service;

import org.springframework.stereotype.Service;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.exception.DuplicateProductCodeException;
import pl.pozsda19.electroshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> showAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> showProductByCode(String code){
        return productRepository.findByCode(code);
    }

    public String addProduct(Product product){
        productRepository.findByCode(product.getCode())
                .ifPresent(product1 -> throwDuplicateProductCodeException(product.getCode()));
        productRepository.save(product);
        return product.getCode();
    }

    private void throwDuplicateProductCodeException(String code){
         throw new DuplicateProductCodeException("Product code "+ code + "in use");
    }
}
