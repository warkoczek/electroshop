package pl.pozsda19.electroshop.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.dto.ShowProductModel;
import pl.pozsda19.electroshop.service.ProductService;

import java.util.Set;

@Controller
public class ProductMVCController {

    private final ProductService productService;

    public ProductMVCController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/showProducts")
    public ModelAndView showProducts(){
        ModelAndView modelAndView = new ModelAndView("showProductsList");
        Set<ShowProductModel> products = productService.showAllProducts();
        modelAndView.addObject("products", products);
        return modelAndView;

    }
}
