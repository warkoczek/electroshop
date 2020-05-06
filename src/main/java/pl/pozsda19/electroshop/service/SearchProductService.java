package pl.pozsda19.electroshop.service;

import org.springframework.stereotype.Service;
import pl.pozsda19.electroshop.domain.dto.ReadProductModel;
import pl.pozsda19.electroshop.repository.ProductRepository;

import java.util.Set;

@Service
public class SearchProductService {

    private final ProductRepository productRepository;
    private final ProductService productService;

    public SearchProductService(ProductRepository productRepository, ProductService productService) {
        this.productRepository = productRepository;
        this.productService = productService;
    }

    public Set<ReadProductModel>
}
