package pl.pozsda19.electroshop.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;

import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.exception.DuplicateProductCodeException;
import pl.pozsda19.electroshop.service.ProductManagementService;
import pl.pozsda19.electroshop.service.ProductService;

import javax.validation.Valid;


@Controller
@RequestMapping("/productAdministration")
public class ProductManagementMVCController {

    private final ProductManagementService productManagementService;
    private final ProductService productService;

    public ProductManagementMVCController(ProductManagementService productManagementService, ProductService productService) {
        this.productManagementService = productManagementService;
        this.productService=productService;
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
        if(productManagementService.productExists(productEntityWriting.getCode())){
            throw new DuplicateProductCodeException("Kod juz istnieje!!!");
        }
        modelAndView.setViewName("productCreated");
        productManagementService.createProduct(productEntityWriting);
        modelAndView.addObject("message", "Nowy produkt został pomyślnie dodany!!!");
        return modelAndView;
    }

    @ExceptionHandler(value = DuplicateProductCodeException.class)
    public String exceptionHandler(){
        return "DuplicateProductCodeException";
    }





}
