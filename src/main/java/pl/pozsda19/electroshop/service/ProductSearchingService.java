package pl.pozsda19.electroshop.service;

import org.springframework.stereotype.Service;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.dto.ProductMapper;
import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;
import pl.pozsda19.electroshop.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


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
                .sorted(Comparator.comparing(Product::getPrice))
                .map(productMapper::readProductEntity)
                .collect(Collectors.toList());
    }
}
