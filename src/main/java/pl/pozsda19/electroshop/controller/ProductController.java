package pl.pozsda19.electroshop.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "", produces = "application/json")
    public List<Product> showAllProducts(){
        return productService.showAllProducts();
    }

    @PostMapping(value = "/product/add", consumes = "application/json")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        return new ResponseEntity(productService.addProduct(product), HttpStatus.CREATED);
    }
}
