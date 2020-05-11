package pl.pozsda19.electroshop.controller.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;
import pl.pozsda19.electroshop.service.ProductSearchingService;

import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductSearchingController {

    private final ProductSearchingService productSearchingService;

    public ProductSearchingController(ProductSearchingService productSearchingService) {
        this.productSearchingService = productSearchingService;
    }

    @GetMapping(value = "/sorted/priceUp/{category}")
    public ResponseEntity<List<ProductEntityReading>> showSortedProductsByCategoryPriceUp(@PathVariable Category category){
        List<ProductEntityReading> products = productSearchingService.showProductsByCategoryPriceUp(category);
        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
}
