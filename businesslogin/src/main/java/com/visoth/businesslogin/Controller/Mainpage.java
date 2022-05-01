package com.visoth.businesslogin.Controller;

import com.visoth.businesslogin.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class Mainpage {

    @Autowired
    private UserService  userService;


    @GetMapping("/")
    public String mainView(){
        return "index";
    }
    @GetMapping("/loginPage")
    public String loginPage(){

        return "loginPage";
    }
    @GetMapping("/forgotPassword")
    public String forgotPassword(){
        return "forgotPassword";
    }
    @PostMapping("/forgotPassword")
    public String forgotPassword(@ModelAttribute("forgotPassword") String email){

        return "redirect:forgotPassword";
    }

    @GetMapping("/luckyNumberPage")
    public String luckyNumerPage(Model model){
        Random rand = new Random();
        String s=Integer.toString(rand.nextInt(100));
        model.addAttribute("number",s);
        return "luckyNumberPage";
    }

    @GetMapping("/AccessDenied")
    public String accessDenied(){
        return "AccessDenied";
    }

}
