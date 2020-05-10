package pl.pozsda19.electroshop.controller.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.Subcategory;
import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;
import pl.pozsda19.electroshop.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "", produces = "application/json")
    public Set<ProductEntityReading> showAllProducts(){
        return productService.showAllProducts();
    }

    @GetMapping(value = "/category/{category}", produces = "application/json")
    public Set<ProductEntityReading> showProductsByCategory(@PathVariable Category category){

        return productService.retrieveProductsByCategory(category);
    }
    @GetMapping(value = "/subcategory/{subcategory}", produces = "application/json")
    public Set<ProductEntityReading> showProductsBySubcategory(@PathVariable Subcategory subcategory){
        return productService.retrieveProductsBySubcategory(subcategory);
    }

    @GetMapping(value = "/product/get/{code}", produces = "application/json")
    public ResponseEntity<Product> showProductByCode(@PathVariable String code){
        Optional<Product> product = productService.retrieveProductByCode(code);
        if(product.isPresent()){
            return ResponseEntity.ok(product.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping(value = "/product/add", consumes = "application/json")
    public ResponseEntity<String> addProduct(@RequestBody Product product){
        return new ResponseEntity(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PostMapping(value = "/product/addAll", consumes = "application/json")
    public ResponseEntity<String> addProducts(@RequestBody List<Product> products){
        return new ResponseEntity(productService.addProducts(products), HttpStatus.CREATED);
    }



}
