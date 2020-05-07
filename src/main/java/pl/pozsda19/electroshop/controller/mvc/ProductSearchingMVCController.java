package pl.pozsda19.electroshop.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.dto.ReadProductModel;
import pl.pozsda19.electroshop.service.ProductSearchingService;

import java.util.List;

@Controller
@RequestMapping("/showProducts")
public class ProductSearchingMVCController {

    private final ProductSearchingService productSearchingService;

    public ProductSearchingMVCController(ProductSearchingService productSearchingService) {
        this.productSearchingService = productSearchingService;
    }

    @GetMapping(value = "/sorted/priceUp/{category}")
    public ModelAndView showSortedProductsByCategoryPriceUp(@PathVariable Category category){
        ModelAndView modelAndView = new ModelAndView("showProductsList");
        List<ReadProductModel> products = productSearchingService.showProductsByCategoryPriceUp(category);
        modelAndView.addObject("products", products);
        return modelAndView;
    }
}
