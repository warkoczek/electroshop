package pl.pozsda19.electroshop.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.exception.DuplicateProductCodeException;
import pl.pozsda19.electroshop.service.ProductService;

import javax.validation.Valid;
import java.util.Optional;
import java.util.Set;

@Controller
@RequestMapping(value = "/showProducts")
public class ProductMVCController {

    private final ProductService productService;

    public ProductMVCController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model){
        model.addAttribute("product", new ProductEntityWriting());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public ModelAndView createProduct(
            @Valid @ModelAttribute("product") ProductEntityWriting productEntityWriting
            , ModelAndView modelAndView){
        if(productService.productExists(productEntityWriting.getCode())){
            throw new DuplicateProductCodeException("Kod juz istnieje!!!");
        }
        modelAndView.setViewName("productCreated");
        productService.createProduct(productEntityWriting);
        modelAndView.addObject("message", "Nowy produkt został pomyślnie dodany!!!");
        return modelAndView;
    }

    @ExceptionHandler(value = DuplicateProductCodeException.class)
    public String exceptionHandler(){
        return "DuplicateProductCodeException";
    }

    @GetMapping(value = "")
    public ModelAndView showProducts(){
        ModelAndView modelAndView = new ModelAndView("showProductsList");
        Set<ProductEntityReading> products = productService.showAllProducts();
        modelAndView.addObject("products", products);
        return modelAndView;

    }
    @GetMapping(value = "/showProduct/{code}")
    public ModelAndView showProductByCode(@PathVariable("code") String code){
        ModelAndView modelAndView = new ModelAndView("showProduct");
        Optional<ProductEntityReading> productModel = productService.getProductByCode(code);
        productModel.ifPresent(showProductModel -> modelAndView.addObject("product", showProductModel));
        return modelAndView;
    }
}
