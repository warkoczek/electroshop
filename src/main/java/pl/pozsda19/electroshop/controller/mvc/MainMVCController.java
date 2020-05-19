package pl.pozsda19.electroshop.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class MainMVCController {

    @GetMapping(value = "/index")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping(value = "/showProductsCSS")
    public String getShowProductsPage(){
        return "showProductsListCSS";
    }

}
