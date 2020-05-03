package pl.pozsda19.electroshop.service;

import org.springframework.stereotype.Service;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Group;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.Subcategory;
import pl.pozsda19.electroshop.domain.dto.ShowProductModel;
import pl.pozsda19.electroshop.domain.dto.ProductModelReader;
import pl.pozsda19.electroshop.exception.DuplicateProductCodeException;
import pl.pozsda19.electroshop.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Set<ShowProductModel> showAllProducts(){
        return productRepository.findAll()
                .stream()
                .map(product -> ProductModelReader.getTypeMap().map(product))
                .collect(Collectors.toSet());
    }

    public Optional<Product> retrieveProductByCode(String code){
        return productRepository.findByCode(code);
    }
    public Optional<ShowProductModel> showProductByCode(String code) {
        return productRepository.findByCode(code).map(product -> ProductModelReader.getTypeMap().map(product));
    }
    public Set<ShowProductModel> retrieveProductsByCategory(Category category){
        //TODO
        return productRepository.findProductsByCategory(category).stream()
                .map(product -> ProductModelReader.getTypeMap().map(product))
                .collect(Collectors.toSet());
    }
    public Set<ShowProductModel> retrieveProductsBySubcategory(Subcategory subcategory){

        return productRepository.findProductsBySubcategory(subcategory).stream()
                .map(product -> ProductModelReader.getTypeMap().map(product))
                .collect(Collectors.toSet());
    }
    public Set<ShowProductModel> retrieveProductsByGroup(Group groupo){
        return productRepository.findProductsByGroupo(groupo).stream()
                .map(product -> ProductModelReader.getTypeMap().map(product))
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
}
