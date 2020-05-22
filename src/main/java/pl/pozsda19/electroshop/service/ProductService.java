package pl.pozsda19.electroshop.service;

import org.springframework.stereotype.Service;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Group;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.Subcategory;
import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.domain.dto.ProductMapper;
import pl.pozsda19.electroshop.exception.DuplicateProductCodeException;
import pl.pozsda19.electroshop.exception.ProductNotFoundException;
import pl.pozsda19.electroshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product createProduct(ProductEntityWriting toProductEntity){
        Product product = productMapper.writeProductEntity(toProductEntity);
        productRepository.save(product);
        return product;
    }
    public boolean productExists(String code){
        return productRepository.existsByCode(code);
    }

    public Set<ProductEntityReading> showAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> productMapper.readProductEntity(product))
                .collect(Collectors.toSet());
    }

    public Optional<Product> retrieveProductByCode(String code){
        return productRepository.findByCode(code);
    }

    public Optional<ProductEntityReading> getProductByCode(String code) {
        return productRepository.findByCode(code).map(product -> productMapper.readProductEntity(product));
    }

    public Set<ProductEntityReading> retrieveProductsByCategory(Category category){
        return productRepository.findProductsByCategory(category).stream()
                .map(product -> productMapper.readProductEntity(product))
                .collect(Collectors.toSet());
    }
    public Set<ProductEntityReading> retrieveProductsBySubcategory(Subcategory subcategory){

        return productRepository.findProductsBySubcategory(subcategory).stream()
                .map(product -> productMapper.readProductEntity(product))
                .collect(Collectors.toSet());
    }
    public Set<ProductEntityReading> retrieveProductsByGroup(Group groupo){
        return productRepository.findProductsByGroupo(groupo).stream()
                .map(product -> productMapper.readProductEntity(product))
                .collect(Collectors.toSet());
    }

   public String addProduct(Product product){
        productRepository.findByCode(product.getCode())
                .ifPresent(product1 -> throwDuplicateProductCodeException(product.getCode()));
        productRepository.save(product);
        return product.getCode();
    }
    private void throwDuplicateProductCodeException(String code){
        throw new DuplicateProductCodeException("Product code "+ code + " in use");
    }

    public String addProducts(List<Product> products) {
        return null;
    }
    public Product updateProduct(ProductEntityWriting productEntityWriting){
        Optional<Product> productFromDB = productRepository.findByCode(productEntityWriting.getCode());
        if(productFromDB.isEmpty()) {
            throw new ProductNotFoundException("Brak produktu o podanym kodzie");
        }

        productRepository.delete(productFromDB.get());
        Product productUpdated = productMapper.writeProductEntity(productEntityWriting);
        productRepository.save(productUpdated);
        return productUpdated;

    }
}
