package com.visoth.businesslogin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Mainpage {

    @GetMapping("/")
    public String mainView(Model model){
        String s="Business Login Main Page";
        model.addAttribute("s",s);
        return "index";
    }
    @GetMapping("/loginPage")
    public String loginPage(){

        return "loginPage";
    }
}
