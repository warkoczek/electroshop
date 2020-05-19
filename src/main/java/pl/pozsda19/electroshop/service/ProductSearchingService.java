package pl.pozsda19.electroshop.service;

import org.springframework.stereotype.Service;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.dto.ProductMapper;
import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;
import pl.pozsda19.electroshop.repository.ProductRepository;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;


@Service
public class ProductSearchingService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductSearchingService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public List<ProductEntityReading> showProductsByCategoryPriceUp(Category category){
       return productRepository.findProductsByCategory(category).stream()
                .sorted(comparing(Product::getPrice))
                .map(productMapper::readProductEntity)
                .collect(Collectors.toList());
    }

    public List<ProductEntityReading> showProductsByCategoryPriceDown(Category category){
        return productRepository.findProductsByCategory(category).stream()
                .sorted(comparing(Product::getPrice).reversed())
                .map(productMapper::readProductEntity)
                .collect(Collectors.toList());
    }
}
