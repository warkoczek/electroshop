package pl.pozsda19.electroshop.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import pl.pozsda19.electroshop.domain.Category;
import pl.pozsda19.electroshop.domain.dto.ReadProductModel;
import pl.pozsda19.electroshop.service.ProductSearchingService;
import pl.pozsda19.electroshop.service.ProductService;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = "/showProducts")
public class ProductMVCController {

    private final ProductService productService;

    public ProductMVCController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "")
    public ModelAndView showProducts(){
        ModelAndView modelAndView = new ModelAndView("showProductsList");
        Set<ReadProductModel> products = productService.showAllProducts();
        modelAndView.addObject("products", products);
        return modelAndView;

    }
    @GetMapping(value = "/showProduct/{code}")
    public ModelAndView showProductByCode(@PathVariable("code") String code){
        ModelAndView modelAndView = new ModelAndView("showProduct");
        Optional<ReadProductModel> productModel = productService.showProductByCode(code);
        productModel.ifPresent(showProductModel -> modelAndView.addObject("product", showProductModel));
        return modelAndView;
    }
}
