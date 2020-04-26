package pl.pozsda19.electroshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.service.ProductService;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/products", produces = "application/json")
    public List<Product> showAllProducts(){
        return productService.showAllProducts();
    }
}
