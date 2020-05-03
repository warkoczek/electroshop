package pl.pozsda19.electroshop.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/main")
public class MainMVCController {

    @GetMapping(value = "")
    public String getMainPage(){
        return "main";
    }
}
