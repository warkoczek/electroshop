package pl.pozsda19.electroshop.controller.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.servlet.ModelAndView;
import pl.pozsda19.electroshop.domain.dto.ProductEntityReading;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.service.ProductManagementService;
import pl.pozsda19.electroshop.service.ProductService;

import java.util.Set;


@Controller
@RequestMapping("/productAdministration")
public class ProductManagementMVCController {

    private final ProductManagementService productManagementService;
    private final ProductService productService;

    public ProductManagementMVCController(ProductManagementService productManagementService, ProductService productService) {
        this.productManagementService = productManagementService;
        this.productService=productService;
    }

    @GetMapping(value = "/showProducts")
    public ModelAndView showProducts() {
        ModelAndView modelAndView = new ModelAndView("showProductsList");
        Set<ProductEntityReading> products = productService.showAllProducts();
        modelAndView.addObject("products", products);
        return modelAndView;
    }

    @GetMapping("/addProduct")
    public String showAddProductForm(){
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String createProduct(@ModelAttribute("product") ProductEntityWriting productEntityWriting, BindingResult result, Model model){
        if(result.hasErrors()){
            return "addProduct";
        }
        productManagementService.createProduct(productEntityWriting);
        model.addAttribute("product", new ProductEntityWriting());
        model.addAttribute("message", "Dodano product");
        return "addProduct";
    }





}
