package pl.pozsda19.electroshop.controller.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import pl.pozsda19.electroshop.domain.Product;
import pl.pozsda19.electroshop.domain.dto.ProductEntityWriting;
import pl.pozsda19.electroshop.service.ProductManagementService;

import javax.validation.Valid;

@Controller
@RequestMapping("/productAdministration")
public class ProductManagementMVCController {

    private final ProductManagementService productManagementService;

    public ProductManagementMVCController(ProductManagementService productManagementService) {
        this.productManagementService = productManagementService;
    }

    @GetMapping(value = "/addProduct")
    public String getAddProductForm(){
        return "addProduct";
    }

    @PostMapping(value = "/add")
    public ModelAndView createProduct(@ModelAttribute ProductEntityWriting productEntityWriting){
        ModelAndView modelAndView = new ModelAndView("addProduct");
        Product product = productManagementService.createProduct(productEntityWriting);

        return null;
    }





}
