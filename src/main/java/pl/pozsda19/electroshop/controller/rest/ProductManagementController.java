package pl.pozsda19.electroshop.controller.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.service.ProductManagementService;

import javax.validation.Valid;

@RestController
@RequestMapping("/productManagement/create")
public class ProductManagementController {

    private final ProductManagementService productManagementService;

    public ProductManagementController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }
    @PostMapping
    public ResponseEntity<Void> createProduct(@Valid @RequestBody ProductEntityWriting toProductEntity, UriComponentsBuilder uriComponentsBuilder){
        String code = productManagementService.createProduct(toProductEntity).getCode();

        UriComponents uriComponents = uriComponentsBuilder.path("/productManagement/create/{code}").buildAndExpand(code);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }
}
