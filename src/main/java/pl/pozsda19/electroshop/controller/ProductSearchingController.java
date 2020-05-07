package pl.pozsda19.electroshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.dto.ReadProductModel;
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
    public ResponseEntity<List<ReadProductModel>> showSortedProductsByCategoryPriceUp(@PathVariable Category category){
        List<ReadProductModel> products = productSearchingService.showProductsByCategoryPriceUp(category);
        if(products.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(products);
    }
}
