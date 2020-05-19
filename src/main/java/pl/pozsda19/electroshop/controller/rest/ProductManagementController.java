package pl.pozsda19.electroshop.controller.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.service.ProductManagementService;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/productManagement")
public class ProductManagementController {

    private final ProductManagementService productManagementService;

    public ProductManagementController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }
    @GetMapping("/allProducts")
    public List<Product> showAllProducts(){
        return productManagementService.showAllProducts();
    }
    @PostMapping(value = "/create")
    public ResponseEntity<Void> createProduct(@RequestBody ProductEntityWriting toProductEntity, UriComponentsBuilder uriComponentsBuilder){
        String code = productManagementService.createProduct(toProductEntity).getCode();

        UriComponents uriComponents = uriComponentsBuilder.path("/productManagement/create/{code}").buildAndExpand(code);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Void> updateProduct(){
        return null;
    }


}
